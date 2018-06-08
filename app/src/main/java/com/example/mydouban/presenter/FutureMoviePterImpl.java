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
public class FutureMoviePterImpl implements MovieInter.MoviePterInter {
    private MovieInter.MovieViewInter<MovieFuture> view;
    private MovieInter.MovieModInter<MovieFuture> modle;

    public FutureMoviePterImpl(MovieInter.MovieViewInter<MovieFuture> view) {
        this.view = view;
        modle = new FutureMovieModelImpl();

    }

    @Override
    public void initData() {
        view.loaderAnimStar();
        modle.getData(new DataCallBack<MovieFuture>() {
            @Override
            public void dataLose(String message) {
                view.loaderAnimStop();
            }

            @Override
            public void dataSucceed(MovieFuture data) {
                view.loaderAnimStop();
                view.notifyData(data);
            }
        });

    }

    @Override
    public void moreData() {

    }
}
