package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.BookAdapter;
import com.example.mydouban.bean.BaseBean;
import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.MovieSearch;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.ui.activity.BookValueActivity;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/24 9:21
 */
public class BookFragment extends BaseFragment {
    @BindView(R.id.rv_book)
    RecyclerView rvBook;
    Unbinder unbinder;
    private Context context;

    private int start;
    private int count;
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
        context = getContext();
        booksBeanList=new ArrayList<>();
        start=0;
        count=20;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        httpData();
        return view;
    }
   private void httpData(){
       HttpUtil.getRetrofit().getTagBooks(title,start,count).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Book>() {
           @Override
           public void onCompleted() {

           }

           @Override
           public void onError(Throwable e) {
               Log.e("TAG", "onNext: "+e.toString());
           }

           @Override
           public void onNext(Book book) {
               booksBeanList.addAll(book.getBooks());
               Log.e("TAG", "onNext: "+booksBeanList.size());
               adapter.notifyDataSetChanged();
               start+=20;
           }
       });

    }

  private void   initView(){
     adapter=new BookAdapter(R.layout.fragment_book_item,booksBeanList,context);
      adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
          @Override
          public void onLoadMoreRequested() {
              rvBook.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                   int is= booksBeanList.size()%20;
                      if (is!=0) {
                          //数据全部加载完毕
                          adapter.loadMoreEnd();
                      } else {
                          httpData();
                          adapter.loadMoreComplete();
                      }
                  }

              }, 100);
          }
      }, rvBook);
      adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
          @Override
          public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
               Book.BooksBean booksBean =booksBeanList.get(position);
              Bundle bundle = new Bundle();
              bundle.putParcelable("BooksBean", booksBean);
              Intent intent = new Intent(context, BookValueActivity.class);
              intent.putExtras(bundle);
              context.startActivity(intent);
          }
      });
     rvBook.setLayoutManager(new GridLayoutManager(context,4));
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
}
