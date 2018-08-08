package com.example.mydouban.searchinter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.bean.Music;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

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
