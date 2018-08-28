package com.example.mydouban.model;

import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import org.reactivestreams.Subscription;

import io.reactivex.disposables.Disposable;


/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/7 9:33
 */
public class BookModelImpl implements BookInter.BookModInter<Book> {
   private String tag;
    private int start;
    private final int COUNT=20;
    private Disposable dispose;
   public BookModelImpl(String tag){
       this.tag=tag;
       start=0;
   }


    @Override
    public void getData(DataCallBack<Book> dataCallBack) {
        start=0;
        httpData(dataCallBack);
    }

    @Override
    public void moreData(DataCallBack<Book> dataCallBack) {
        httpData(dataCallBack);
    }

    private void httpData(final DataCallBack<Book> dataCallBack){
       HttpUtil.getRetrofit()
                .getTagBooks(tag,start,COUNT)
                .compose(HttpUtil.<Book>compatResult())
                .subscribe(new MySubscriber<Book>(dataCallBack){
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        dispose=d;
                    }

                    @Override
            public void onNext(Book book) {
                super.onNext(book);
                start+=20;
            }
        });


    }

    @Override
    public void unsubscribe() {
        if(!dispose.isDisposed()){
            dispose.dispose();
        }
    }
}
