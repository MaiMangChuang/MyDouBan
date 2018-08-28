package com.example.mydouban.util;


import com.example.mydouban.inte.RetrofitInter;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/7/19 19:00
 */
public final class HttpUtil {
    private static RetrofitInter retrofit;
    private static final String URL = "https://api.douban.com";

    public static RetrofitInter getRetrofit() {
        if (retrofit == null) {
            synchronized (HttpUtil.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder().baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build().create(RetrofitInter.class);
                }
            }
        }
        return retrofit;
    }


    public static <T> ObservableTransformer<T,T> compatResult() {

        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(io.reactivex.Observable<T> upstream) {
                return upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }


        };


    }

}
