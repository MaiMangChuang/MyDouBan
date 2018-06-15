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
public class HotMoviePterImpl extends BasePresenter<MovieInter.MovieViewInter<MovieHot>,MovieInter.MovieModInter<MovieHot>> implements MovieInter.MoviePterInter {


  public   HotMoviePterImpl(MovieInter.MovieViewInter<MovieHot> view){
      super(view,new HotMovieModelImpl());

    }

    @Override
    public void initData() {
        mView.loaderAnimStar();
        mModel.getData(new DataCallBack<MovieHot>() {
            @Override
            public void dataLose(String message) {
                mView.loaderAnimStop();
            }

            @Override
            public void dataSucceed(MovieHot data) {
                mView.notifyData(data);
                mView.loaderAnimStop();
            }
        });
    }

    @Override
    public void moreData() {

    }


}
