package com.example.mydouban.SearchInter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.bean.Music;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：音乐查询实现类
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 23:59
 */
public class MusicSearch implements SearchCall{


    @Override
    public void searchCall(String value, final BaseQuickAdapter adapter) {
        HttpUtil.getRetrofit().getSearchMusic(value,0,20)
               .compose(HttpUtil.<Music>compatResult())
                .subscribe(new MySubscriber<Music>() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Music music) {
                adapter.getData().clear();
                adapter.getData().addAll(music.getMusics());
                adapter.notifyDataSetChanged();
            }
        });

    }
}
