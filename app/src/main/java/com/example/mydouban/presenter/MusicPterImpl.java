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
public class MusicPterImpl extends BasePresenter<MusicInter.MusicViewInter<Music>,MusicInter.MusicModInter<Music>> implements MusicInter.MusicPterInter {

    private MusicCallBack callBack;


    public MusicPterImpl(MusicInter.MusicViewInter<Music> view,String tag){
        super(view,new MusicModelImpl(tag));
        callBack=new MusicCallBack();
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

    class MusicCallBack implements DataCallBack<Music> {

        @Override
        public void dataLose(String message) {

                mView.showDiao();


        }

        @Override
        public void dataSucceed(Music data) {

                mView.notifyData(data);
                mView.loaderAnimStop();

        }
    }

}
