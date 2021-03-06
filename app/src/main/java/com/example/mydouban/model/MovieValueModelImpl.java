package com.example.mydouban.model;

import com.example.mydouban.bean.MovieValue;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import io.reactivex.disposables.Disposable;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:47
 */
public class MovieValueModelImpl implements MovieInter.MovieModInter<MovieValue> {
    private String tag;
    private Disposable disposable;
    public  MovieValueModelImpl(String tag){
        this.tag=tag;
    }

    @Override
    public void getData(final DataCallBack<MovieValue> dataCallBack) {

        HttpUtil.getRetrofit()
                .getMovieValue(tag)
               .compose(HttpUtil.<MovieValue>compatResult())
                .subscribe(new MySubscriber<MovieValue>(dataCallBack){
                    @Override
                    public void onSubscribe(Disposable d) {
                        super.onSubscribe(d);
                        disposable=d;
                    }
                });


    }

    @Override
    public void moreData(DataCallBack<MovieValue> dataCallBack) {

    }

    @Override
    public void unsubscribe() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
