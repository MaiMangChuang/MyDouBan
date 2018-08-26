package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mydouban.R;
import com.example.mydouban.inte.BasePresenterInter;
import com.example.mydouban.inte.ProgressInter;
import com.example.mydouban.util.ShowUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/8/7 15:36
 */
public abstract class AbstractProgressFragment<T extends BasePresenterInter> extends Fragment implements ProgressInter {


    /**
     * 设置Fragment的布局内容
     */
    public abstract int getLayoutResID();

    /**
     * 进行数据的初始化等工作，运行在onCreateView中
     */
    public abstract void init();


    private FrameLayout mRootView;
    private View mViewProgress;
    private FrameLayout mViewContent;
    private View mViewEmpty;
    Unbinder unbinder;
    protected ShowUtil showUtil;
    private TextView mTextError;

    protected T presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (FrameLayout) inflater.inflate(R.layout.progress, container, false);
        mViewProgress = mRootView.findViewById(R.id.view_progress);
        mViewContent = mRootView.findViewById(R.id.view_content);
        mViewEmpty = mRootView.findViewById(R.id.view_empty);
        mTextError = mRootView.findViewById(R.id.text_tip);
        mViewEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEmptyViewClick();
            }
        });
        showUtil = new ShowUtil(getContext());
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRealContentView();
        init();
    }

    public void onEmptyViewClick() {

    }

    private void setRealContentView() {
        View realContentView = LayoutInflater.from(getActivity()).inflate(getLayoutResID(), mViewContent, true);
        unbinder = ButterKnife.bind(this, realContentView);

    }


    private void showProgressView() {
        showView(R.id.view_progress);

    }

    public void showContentView() {
        showView(R.id.view_content);
    }

    public void showEmptyView() {
        showView(R.id.view_empty);
    }


    public void showEmptyView(int resId) {
        showEmptyView();
        mTextError.setText(resId);
    }

    public void showEmptyView(String msg) {
        showEmptyView();
        mTextError.setText(msg);
    }


    public void showView(int viewId) {

        for (int i = 0; i < mRootView.getChildCount(); i++) {

            if (mRootView.getChildAt(i).getId() == viewId) {

                mRootView.getChildAt(i).setVisibility(View.VISIBLE);
            } else {
                mRootView.getChildAt(i).setVisibility(View.GONE);
            }

        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.relieve();
            presenter = null;
        }
        if (unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }

    }

    @Override
    public void showLoading() {
        showProgressView();
    }

    @Override
    public void showError(String msg) {
        showEmptyView(msg);
    }

    @Override
    public void showValue() {
        showContentView();
    }


}
