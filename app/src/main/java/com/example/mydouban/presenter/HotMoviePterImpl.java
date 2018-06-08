package com.example.mydouban.presenter;

import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.model.HotMovieModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/6 23:47
 */
public class HotMoviePterImpl implements MovieInter.MoviePterInter {
private MovieInter.MovieViewInter<MovieHot> view;
private MovieInter.MovieModInter<MovieHot> modle;

  public   HotMoviePterImpl(MovieInter.MovieViewInter<MovieHot> view){
        this.view=view;
         modle=new HotMovieModelImpl();
    }

    @Override
    public void initData() {
        view.loaderAnimStar();
        modle.getData(new DataCallBack<MovieHot>() {
            @Override
            public void dataLose(String message) {
                view.loaderAnimStop();
            }

            @Override
            public void dataSucceed(MovieHot data) {
                view.notifyData(data);
                view.loaderAnimStop();
            }
        });
    }

    @Override
    public void moreData() {

    }


}
