package com.example.mydouban.model;

import android.util.Log;

import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.util.HttpUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/5 23:58
 */
public class TopMovieModelImpl implements MovieInter.MovieModInter<MovieTop250> {
   private int start;
   private  final int COUNT = 20;


public TopMovieModelImpl(){
    Log.e("TopMovieModelImpl", "TopMovieModelImpl: ");
}

    private void httpData(final DataCallBack<MovieTop250> dataCallBack) {

        HttpUtil.getRetrofit().getTopMovies(start, COUNT).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MovieTop250>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                dataCallBack.dataLose(e.toString());
            }

            @Override
            public void onNext(MovieTop250 movieTop250) {
                int listSize = movieTop250.getSubjects().size();
                initStar(listSize);
                dataCallBack.dataSucceed(movieTop250);
            }
        });
    }

    private void initStar(int listSize){
        if (listSize < 250) {
            if (listSize + 20 <= 250) {
                start += 20;
            } else {
                start += 250 - listSize;
            }
        }

    }

    @Override
    public void getData(DataCallBack<MovieTop250> dataCallBack) {
        start = 0;

        httpData(dataCallBack);
    }

    @Override
    public void moreData(DataCallBack<MovieTop250> dataCallBack) {
        httpData(dataCallBack);
    }
}
