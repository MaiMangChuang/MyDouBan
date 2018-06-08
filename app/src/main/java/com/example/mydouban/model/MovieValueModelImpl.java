package com.example.mydouban.model;

import com.example.mydouban.bean.MovieValue;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.GlideUtil;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.ProjectUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:47
 */
public class MovieValueModelImpl implements MovieInter.MovieModInter<MovieValue> {
    private String tag;
    public  MovieValueModelImpl(String tag){
        this.tag=tag;
    }

    @Override
    public void getData(final DataCallBack<MovieValue> dataCallBack) {
        HttpUtil.getRetrofit().getMovieValue(tag).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MovieValue>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                dataCallBack.dataLose(e.toString());
            }

            @Override
            public void onNext(MovieValue movieValue) {
                dataCallBack.dataSucceed(movieValue);
            }
        });
    }

    @Override
    public void moreData(DataCallBack<MovieValue> dataCallBack) {

    }
}
