package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.BookAdapter;
import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.presenter.BookPterImpl;
import com.example.mydouban.ui.activity.BookValueActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/24 9:21
 */
public class BookFragment extends AbstractViewPagerProgressFragment<BookInter.BookPterInter> implements BookInter.BookViewInter<Book> {
    @BindView(R.id.rv_book)
    RecyclerView rvBook;
    Unbinder unbinder;
    private List<Book.BooksBean> booksBeanList;
    private BookAdapter adapter;
    private String title;


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
        booksBeanList = new ArrayList<>();

    }



    @Override
    public int getLayoutResID() {
        return R.layout.fragment_book;
    }

    @Override
    public void init() {
        presenter = new BookPterImpl(this, title);
        initView();
        presenter.initData();
    }


    private void initView() {
        adapter = new BookAdapter(R.layout.fragment_book_item, booksBeanList, getActivity().getApplicationContext());
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
                            if(presenter!=null){
                                presenter.moreData();
                            }
                            adapter.loadMoreComplete();
                        }
                    }

                }, 500);
            }
        }, rvBook);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Book.BooksBean booksBean = booksBeanList.get(position);
                showUtil.myStartActivity(BookValueActivity.class, "BooksBean", booksBean);
            }
        });
        rvBook.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 4));
        rvBook.setAdapter(adapter);
    }





    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void loaderAnimStar() {
        showLoading();

    }

    @Override
    public void loaderAnimStop() {
        showContentView();
    }

    @Override
    public void notifyData(Book data) {
        booksBeanList.addAll(data.getBooks());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDiao() {
            showEmptyView();
    }


    @Override
    public String getTitle() {
        return title;
    }


}
