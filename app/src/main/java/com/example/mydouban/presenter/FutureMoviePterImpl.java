package com.example.mydouban.presenter;

import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.model.FutureMovieModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/7 0:16
 */
public class FutureMoviePterImpl extends BasePresenter<MovieInter.MovieViewInter<MovieFuture>,MovieInter.MovieModInter<MovieFuture>> implements MovieInter.MoviePterInter {


    public FutureMoviePterImpl(MovieInter.MovieViewInter<MovieFuture> view) {
        super(view,new FutureMovieModelImpl());


    }

    @Override
    public void initData() {
        mView.loaderAnimStar();
        mModel.getData(new DataCallBack<MovieFuture>() {
            @Override
            public void dataLose(String message) {
                mView.showDiao();
            }

            @Override
            public void dataSucceed(MovieFuture data) {
                mView.loaderAnimStop();
                mView.notifyData(data);
            }
        });

    }

    @Override
    public void moreData() {

    }
}
