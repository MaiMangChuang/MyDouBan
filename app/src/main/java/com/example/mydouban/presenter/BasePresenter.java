package com.example.mydouban.presenter;

import android.util.Log;

import com.example.mydouban.inte.BaseModel;
import com.example.mydouban.inte.BasePresenterInter;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/16 3:42
 */
public abstract class BasePresenter<V,M extends BaseModel> implements BasePresenterInter{
    V mView;
     M mModel;

    BasePresenter(V mView,M mModel){
        this.mView=mView;
        this.mModel=mModel;
    }

    @Override
    public void relieve() {
        Log.e("TAG", "relieve: 已执行");
        mModel.unsubscribe();
        mView=null;
        mModel=null;
    }
}
