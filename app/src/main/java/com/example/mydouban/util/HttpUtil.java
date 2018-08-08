package com.example.mydouban.util;


import com.example.mydouban.inte.RetrofitInter;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/7/19 19:00
 */
public final class HttpUtil {
    private static RetrofitInter retrofit;
    public static final String URL = "https://api.douban.com";

    public static RetrofitInter getRetrofit() {
        if (retrofit == null) {
            synchronized (HttpUtil.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder().baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build().create(RetrofitInter.class);
                }
            }
        }
        return retrofit;
    }


    public static <T> Observable.Transformer<T,T> compatResult() {

        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return   tObservable .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };


    }


}
