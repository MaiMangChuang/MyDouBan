package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydouban.R;
import com.example.mydouban.inte.BasePresenterInter;
import com.example.mydouban.inte.ViewPagerInter;
import com.example.mydouban.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 17:28
 */
public abstract class  BaseFragment<T extends BasePresenterInter> extends Fragment  {
    public abstract String getTiele();
    protected T presenter;
    Unbinder unbinder;
    public  void myStartActivity(Context context, Class<?> cls, String key , Parcelable value){
        Bundle bundle = new Bundle();
        bundle.putParcelable(key, value);
        Intent intent=new Intent(context,cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResID(), container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.relieve();
            presenter=null;
        }
        unbinder.unbind();
    }
    /**
     * 设置Fragment的布局内容
     */
    public abstract int getLayoutResID();

    /**
     * 进行数据的初始化等工作，运行在onCreateView中
     */
    public abstract void init();
}
