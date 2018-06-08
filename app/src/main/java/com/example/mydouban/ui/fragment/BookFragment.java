package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.BookAdapter;
import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.presenter.BookPterImpl;
import com.example.mydouban.ui.activity.BookValueActivity;
import com.example.mydouban.util.LoaderAnim;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/24 9:21
 */
public class BookFragment extends BaseFragment implements BookInter.BookViewInter<Book> {
    @BindView(R.id.rv_book)
    RecyclerView rvBook;
    Unbinder unbinder;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    private Context context;
    private List<Book.BooksBean> booksBeanList;
    private BookAdapter adapter;
    private String title;
    private BookInter.BookPterInter presenter;
    private LoaderAnim loaderAnim;

    public void setTitle(String title) {
        this.title = title;
    }

    public static BookFragment newInstance(String title) {
        BookFragment bf = new BookFragment();
        bf.setTitle(title);
        return bf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        booksBeanList = new ArrayList<>();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new BookPterImpl(this, title);
        loaderAnim=new LoaderAnim(ivLoader);
        initView();
        presenter.initData();
        return view;
    }


    private void initView() {
        adapter = new BookAdapter(R.layout.fragment_book_item, booksBeanList, context);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvBook.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int is = booksBeanList.size() % 20;
                        if (is != 0) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        } else {
                            presenter.moreData();
                            adapter.loadMoreComplete();
                        }
                    }

                }, 800);
            }
        }, rvBook);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Book.BooksBean booksBean = booksBeanList.get(position);
                myStartActivity(context, BookValueActivity.class, "BooksBean", booksBean);
            }
        });
        rvBook.setLayoutManager(new GridLayoutManager(context, 4));
        rvBook.setAdapter(adapter);
    }

    @Override
    public String getTiele() {
        return title;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onStop() {
        loaderAnim.stopAnim();
        super.onStop();
    }

    @Override
    public void loaderAnimStar() {
        loaderAnim.starAnim();
    }

    @Override
    public void loaderAnimStop() {
        loaderAnim.stopAnim();
    }

    @Override
    public void notifyData(Book data) {
        booksBeanList.addAll(data.getBooks());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDiao() {

    }
}
