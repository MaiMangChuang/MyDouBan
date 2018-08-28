package com.example.mydouban.util;

import com.example.mydouban.inte.DataCallBack;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/7/8 21:39
 */
public  class MySubscriber<T> implements Observer<T> {
    DataCallBack<T> dataCallBack;
   public MySubscriber(DataCallBack<T> dataCallBack){
        super();
       this.dataCallBack=dataCallBack;
    }

    public MySubscriber(){
    }


    @Override
    public void onError(Throwable e) {
       if(dataCallBack!=null){
           dataCallBack.dataLose(e.toString());
       }

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        if(dataCallBack!=null){
            dataCallBack.dataSucceed(t);
        }

    }

}
