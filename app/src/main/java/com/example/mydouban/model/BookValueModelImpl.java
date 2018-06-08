package com.example.mydouban.model;

import android.view.View;

import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.util.HttpUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:18
 */
public class BookValueModelImpl implements BookInter.BookModInter<Book> {
private String tag;
    public BookValueModelImpl(String tag) {
        this.tag = tag;
    }

    @Override
    public void getData(DataCallBack<Book> dataCallBack) {
        httpDate(dataCallBack);
    }

    @Override
    public void moreData(DataCallBack<Book> dataCallBack) {

    }

    private void httpDate(final DataCallBack<Book> dataCallBack) {
        HttpUtil.getRetrofit().getAuthorBooks(tag)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Book>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                dataCallBack.dataLose(e.toString());
            }

            @Override
            public void onNext(Book book) {
                dataCallBack.dataSucceed(book);
            }
        });


    }
}
