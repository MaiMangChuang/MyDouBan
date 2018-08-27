package com.example.mydouban.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mydouban.inte.BasePresenterInter;
import com.example.mydouban.util.ShowUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/1/7 16:48
 * @author Administrator
 */
  public abstract class BaseAppCompatActivity<T extends BasePresenterInter> extends AppCompatActivity {
    protected ShowUtil showUtil;
    protected T presenter;
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        showUtil=new ShowUtil(this);
        unbinder= ButterKnife.bind(this);
    }

    /**
     * 设置布局
     * @return 放回布局id
     */
    public abstract int getLayoutResID();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.relieve();
            presenter=null;
        }
        if(unbinder != Unbinder.EMPTY){
            unbinder.unbind();
        }

    }





}
