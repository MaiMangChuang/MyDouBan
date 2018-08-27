package com.example.mydouban.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
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
 *
 * @author maimanchuang
 * @date 2018/8/8
 */
public abstract class AbstractProgressActivity<T extends BasePresenterInter> extends AppCompatActivity implements ProgressInter {
    protected ShowUtil showUtil;
    protected T presenter;
    Unbinder unbinder;
    private FrameLayout mRootView;
    private View mViewProgress;
    private FrameLayout mViewContent;
    private View mViewEmpty;
    private TextView mTextError;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);
        showUtil=new ShowUtil(this);
        mRootView=findViewById(R.id.rootView);
        mViewProgress = findViewById(R.id.view_progress);
        mViewContent =  findViewById(R.id.view_content);
        mViewEmpty = findViewById(R.id.view_empty);
        mTextError =  findViewById(R.id.text_tip);
        mViewEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEmptyViewClick();
            }
        });
        setRealContentView();
         init();
    }

    /**
     * 设置布局
     * @return 放回布局id
     */
    public abstract int getLayoutResID();


    /**
     * 进行数据的初始化等工作，运行在onCreateView中
     */
    public abstract void init();




    public void onEmptyViewClick(){

    }

    private void setRealContentView() {
        View realContentView=  LayoutInflater.from(this).inflate(getLayoutResID(),mViewContent,true);
        unbinder=  ButterKnife.bind(this, realContentView);

    }



    private void  showProgressView(){
        showView(R.id.view_progress);

    }

    public void showContentView(){
        showView(R.id.view_content);
    }

    public void showEmptyView(){
        showView(R.id.view_empty);
    }


    public void showEmptyView(int resId){
        showEmptyView();
        mTextError.setText(getString(resId));
    }

    public void showEmptyView(String msg){
        showEmptyView();
        mTextError.setText(msg);
    }



    public void showView(int viewId){

        for(int i=0;i<mRootView.getChildCount();i++){

            if( mRootView.getChildAt(i).getId() == viewId){

                mRootView.getChildAt(i).setVisibility(View.VISIBLE);
            }
            else {
                mRootView.getChildAt(i).setVisibility(View.GONE);
            }

        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.relieve();
            presenter=null;
        }
        if(unbinder != Unbinder.EMPTY){
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
