package com.example.mydouban.searchinter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

/**
 * 类描述：书籍查询实现类
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 23:59
 */
public class BookSearch implements SearchCall {


    @Override
    public void searchCall(String value, final BaseQuickAdapter adapter) {
        HttpUtil.getRetrofit().getSearchBooks(value,0,20)
                .compose(HttpUtil.<Book>compatResult())
                .subscribe(new MySubscriber<Book>(){
                    @Override
                    public void onNext(Book book) {
                        super.onNext(book);
                        adapter.getData().clear();
                        adapter.getData().addAll(book.getBooks());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });



    }
}
