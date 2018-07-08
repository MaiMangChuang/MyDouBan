package com.example.mydouban.model;

import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/7 0:12
 */
public class FutureMovieModelImpl implements MovieInter.MovieModInter<MovieFuture> {
    @Override
    public void getData(final DataCallBack<MovieFuture> dataCallBack) {
        HttpUtil.getRetrofit().getFutureMovies()
               .compose(HttpUtil.<MovieFuture>compatResult())
                .subscribe(new MySubscriber<MovieFuture>(dataCallBack));


    }

    @Override
    public void moreData(DataCallBack<MovieFuture> dataCallBack) {

    }
}
