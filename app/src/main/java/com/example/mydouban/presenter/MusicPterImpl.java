package com.example.mydouban.presenter;

import com.example.mydouban.bean.Music;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MusicInter;
import com.example.mydouban.model.MusicModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 1:35
 */
public class MusicPterImpl implements MusicInter.MusicPterInter {
    private MusicInter.MusicViewInter<Music> view;
    private MusicInter.MusicModInter<Music> modle;
    private MusicCallBack callBack;


    public MusicPterImpl(MusicInter.MusicViewInter<Music> view,String tag){
        this.view=view;
        modle=new MusicModelImpl(tag);
        callBack=new MusicCallBack();
    }

    @Override
    public void initData() {
        view.loaderAnimStar();
        modle.getData(callBack);
    }

    @Override
    public void moreData() {
        modle.moreData(callBack);
    }

    class MusicCallBack implements DataCallBack<Music> {

        @Override
        public void dataLose(String message) {
            view.loaderAnimStop();
            view.showDiao();
        }

        @Override
        public void dataSucceed(Music data) {
            view.notifyData(data);
            view.loaderAnimStop();
        }
    }

}
