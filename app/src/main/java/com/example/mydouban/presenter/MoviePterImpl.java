package com.example.mydouban.presenter;

import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.bean.MovieValue;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.model.MovieValueModelImpl;
import com.example.mydouban.model.TopMovieModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:50
 */
public class MoviePterImpl implements MovieInter.MoviePterInter {
    private MovieInter.MovieViewInter<MovieValue> mView;
    private MovieInter.MovieModInter<MovieValue> mModel;

    public MoviePterImpl(MovieInter.MovieViewInter<MovieValue> mView,String tag){
        this.mView=mView;
        this.mModel=new MovieValueModelImpl(tag);

    }
    @Override
    public void initData() {
        mView.loaderAnimStar();
        mModel.getData(new DataCallBack<MovieValue>() {
            @Override
            public void dataLose(String message) {
                mView.loaderAnimStop();
            }

            @Override
            public void dataSucceed(MovieValue data) {
                mView.loaderAnimStop();
                mView.notifyData(data);
            }
        });
    }

    @Override
    public void moreData() {

    }
}
