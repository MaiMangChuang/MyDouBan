package com.example.mydouban.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.mydouban.R;
import com.example.mydouban.inte.AnimInter;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/24 9:36
 */
public class LoaderAnim implements AnimInter {
    private View view;

    public LoaderAnim(View view) {
        this.view = view;
    }


    @Override
    public void starAnim() {
        Animation rotate = AnimationUtils.loadAnimation(view.getContext(), R.anim.loader_anim);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(rotate);
    }

    @Override
    public void stopAnim() {
        view.setVisibility(View.GONE);
        view.clearAnimation();
    }
}
