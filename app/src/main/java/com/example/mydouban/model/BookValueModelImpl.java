package com.example.mydouban.model;

import android.view.View;

import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.Music;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:18
 */
public class BookValueModelImpl implements BookInter.BookModInter<Book> {
    private String tag;
    private MySubscriber<Book> subscribe;
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
        subscribe=new MySubscriber<Book>(dataCallBack);
        HttpUtil.getRetrofit()
                .getAuthorBooks(tag)
                .compose(HttpUtil.<Book>compatResult())
                .subscribe(subscribe);




    }

    @Override
    public void unsubscribe() {
        if(subscribe!=null&&subscribe.isUnsubscribed()){
            subscribe.unsubscribe();
        }
    }
}
