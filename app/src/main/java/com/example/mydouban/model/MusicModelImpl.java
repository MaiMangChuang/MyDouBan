package com.example.mydouban.model;

import android.util.Log;

import com.example.mydouban.bean.Music;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MusicInter;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.MySubscriber;

import javax.security.auth.login.LoginException;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 1:30
 */
public class MusicModelImpl implements MusicInter.MusicModInter<Music> {
    private int start;
    private final int COUNT = 20;
    private String tag;

    public MusicModelImpl(String tag) {
        this.tag = tag;
        start = 0;
    }

    @Override
    public void getData(DataCallBack<Music> dataCallBack) {
        start = 0;
        httpData(dataCallBack);
    }

    @Override
    public void moreData(DataCallBack<Music> dataCallBack) {
        httpData(dataCallBack);
    }

    private void httpData(final DataCallBack<Music> dataCallBack) {
        HttpUtil.getRetrofit().getTagMusic(tag, start, COUNT)
               .compose(HttpUtil.<Music>compatResult())
                .subscribe(new MySubscriber<Music>(dataCallBack) {
                    @Override
                    public void onNext(Music music) {
                        super.onNext(music);
                        start += 20;
                    }

        });
    }

}
