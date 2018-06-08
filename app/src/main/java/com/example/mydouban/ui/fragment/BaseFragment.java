package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

import com.example.mydouban.inte.ViewPagerInter;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 17:28
 */
public abstract class  BaseFragment extends Fragment  {
    public abstract String getTiele();
    public  void myStartActivity(Context context, Class<?> cls, String key , Parcelable value){
        Bundle bundle = new Bundle();
        bundle.putParcelable(key, value);
        Intent intent=new Intent(context,cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
