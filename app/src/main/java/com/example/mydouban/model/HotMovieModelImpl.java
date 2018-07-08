package com.example.mydouban.model;

import android.util.Log;

import com.example.mydouban.bean.MovieHot;
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
 * 创建时间：2018/6/6 23:37
 */
public class HotMovieModelImpl implements MovieInter.MovieModInter<MovieHot> {

    @Override
    public void getData(final DataCallBack<MovieHot> dataCallBack) {

        HttpUtil.getRetrofit().getHotMovies()
              .compose(HttpUtil.<MovieHot>compatResult())
                .subscribe(new MySubscriber<MovieHot>(dataCallBack));




        }


    @Override
    public void moreData(DataCallBack<MovieHot> dataCallBack) {

    }
}
