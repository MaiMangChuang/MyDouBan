package com.example.mydouban.SearchInter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieHotAdapter;
import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 类描述：电影查询实现类
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 23:58
 */
public class MovieSearch implements SearchCall {

    @Override
    public void searchCall(String value, final BaseQuickAdapter adapter) {

        HttpUtil.getRetrofit().getSearchMovies(value,0,20).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<com.example.mydouban.bean.MovieSearch>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(com.example.mydouban.bean.MovieSearch movieSearch) {
                adapter.getData().clear();
                adapter.getData().addAll(movieSearch.getSubjects());
                adapter.notifyDataSetChanged();
            }
        });


    }

}
