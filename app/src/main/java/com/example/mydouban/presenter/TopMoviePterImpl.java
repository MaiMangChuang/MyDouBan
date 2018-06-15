package com.example.mydouban.presenter;

import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.model.TopMovieModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/5 23:10
 */
public class TopMoviePterImpl extends BasePresenter<MovieInter.MovieViewInter<MovieTop250>,MovieInter.MovieModInter<MovieTop250>> implements MovieInter.MoviePterInter{

 private TopMovieCallBack callBack;

   public TopMoviePterImpl(MovieInter.MovieViewInter<MovieTop250> mView){
       super(mView,new TopMovieModelImpl());
        callBack=new TopMovieCallBack();
    }

    @Override
    public void initData() {
       mView.loaderAnimStar();
       mModel.getData(callBack);
    }

    @Override
    public void moreData() {
        mModel.moreData(callBack);
    }

   class TopMovieCallBack implements DataCallBack<MovieTop250>{

       @Override
       public void dataLose(String message) {
           mView.loaderAnimStop();
       }

       @Override
       public void dataSucceed(MovieTop250 data) {
           mView.notifyData(data);
           mView.loaderAnimStop();
       }
   }

}
