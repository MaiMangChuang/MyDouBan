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
public class MoviePterImpl extends BasePresenter<MovieInter.MovieViewInter<MovieValue>,MovieInter.MovieModInter<MovieValue>> implements MovieInter.MoviePterInter {


    public MoviePterImpl(MovieInter.MovieViewInter<MovieValue> mView,String tag){
        super(mView,new MovieValueModelImpl(tag));

    }
    @Override
    public void initData() {
        mView.loaderAnimStar();
        mModel.getData(new DataCallBack<MovieValue>() {
            @Override
            public void dataLose(String message) {
                mView.loaderAnimStop();
                mView.showDiao();
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
