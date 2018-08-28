package com.example.mydouban.model;

import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import io.reactivex.disposables.Disposable;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/7 0:12
 */
public class FutureMovieModelImpl implements MovieInter.MovieModInter<MovieFuture> {
    private Disposable disposable;
    @Override
    public void getData(final DataCallBack<MovieFuture> dataCallBack) {

        HttpUtil.getRetrofit().getFutureMovies()
               .compose(HttpUtil.<MovieFuture>compatResult())
                .subscribe(new MySubscriber<MovieFuture>(dataCallBack){
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        disposable=d;
                    }
                });
    }

    @Override
    public void moreData(DataCallBack<MovieFuture> dataCallBack) {

    }

    @Override
    public void unsubscribe() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
