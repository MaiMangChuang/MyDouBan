package com.example.mydouban.presenter;

import com.example.mydouban.inte.BasePresenterInter;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/16 3:42
 */
public abstract class BasePresenter<V,M> implements BasePresenterInter{
    protected V mView;
    protected M mModel;

    BasePresenter(V mView,M mModel){
        this.mView=mView;
        this.mModel=mModel;
    }

    @Override
    public void relieve() {
        mView=null;
        mModel=null;
    }
}
