package com.example.mydouban.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mydouban.inte.BasePresenterInter;
import com.example.mydouban.presenter.BasePresenter;
import com.example.mydouban.util.ActivityLife;
import com.example.mydouban.util.ShowUtil;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/1/7 16:48
 */
  public abstract class BaseAppCompatActivity<T extends BasePresenterInter> extends AppCompatActivity {
    protected List<Activity> activityList = ActivityLife.getActivityList();
    protected ShowUtil showUtil;
    protected T presenter;
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        showUtil=new ShowUtil(this);
        activityList.add(this);
        unbinder= ButterKnife.bind(this);
    }
    public abstract int getLayoutResID();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.relieve();
            presenter=null;
        }
        activityList.remove(this);
       unbinder.unbind();

    }

    public void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activityList.clear();

    }

    public void myFinish() {
        activityList.remove(this);
        this.finish();
    }
    public  void myStartActivity( Class<?> cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }
    public  void myStartActivity( Class<?> cls,String key ,Parcelable value){
        Bundle bundle = new Bundle();
        bundle.putParcelable(key, value);
        Intent intent=new Intent(this,cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public  void myStartActivity( Class<?> cls,String key ,String value){
        Intent intent=new Intent(this,cls);
        intent.putExtra(key, value);
        startActivity(intent);
    }


}
