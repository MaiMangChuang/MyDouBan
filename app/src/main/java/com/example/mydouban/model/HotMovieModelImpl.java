package com.example.mydouban.model;

import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/6 23:37
 */
public class HotMovieModelImpl implements MovieInter.MovieModInter<MovieHot> {
    private MySubscriber<MovieHot> subscriber;
    @Override
    public void getData(final DataCallBack<MovieHot> dataCallBack) {
          subscriber=new MySubscriber<MovieHot>(dataCallBack);
        HttpUtil.getRetrofit().getHotMovies()
              .compose(HttpUtil.<MovieHot>compatResult())
                .subscribe(subscriber);




        }


    @Override
    public void moreData(DataCallBack<MovieHot> dataCallBack) {

    }

    @Override
    public void unsubscribe() {
        if(subscriber!=null&&subscriber.isUnsubscribed()){
            subscriber.unsubscribe();
        }
    }
}
