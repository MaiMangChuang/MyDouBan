package com.example.mydouban.searchinter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

/**
 * 类描述：电影查询实现类
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 23:58
 */
public class MovieSearch implements SearchCall {

    @Override
    public void searchCall(String value, final BaseQuickAdapter adapter) {

        HttpUtil.getRetrofit().getSearchMovies(value,0,20)
                .compose(HttpUtil.<com.example.mydouban.bean.MovieSearch>compatResult())
                .subscribe(new MySubscriber<com.example.mydouban.bean.MovieSearch >() {
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
