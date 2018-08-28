package com.example.mydouban.model;

import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import io.reactivex.disposables.Disposable;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:18
 */
public class BookValueModelImpl implements BookInter.BookModInter<Book> {
    private String tag;
    private Disposable disposable;

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
        HttpUtil.getRetrofit()
                .getAuthorBooks(tag)
                .compose(HttpUtil.<Book>compatResult())
                .subscribe(new MySubscriber<Book>(dataCallBack) {
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        disposable = d;
                    }
                });
    }

    @Override
    public void unsubscribe() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
