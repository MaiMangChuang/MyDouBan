package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieFutureAdapter;
import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.presenter.FutureMoviePterImpl;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.LoaderAnim;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 17:27
 */
public class FutureMovieFragment extends BaseFragment<MovieInter.MoviePterInter> implements MovieInter.MovieViewInter<MovieFuture> {

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    Unbinder unbinder;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    private List<SubjectsBean> subjectsBeanRVList;
    private MovieFutureAdapter adapter;
    private Context context;
    private LoaderAnim loaderAnim;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }



    @Override
    public int getLayoutResID() {
        return R.layout.fragment_futuremovie;
    }

    @Override
    public void init() {
        presenter = new FutureMoviePterImpl(this);
        loaderAnim=new LoaderAnim(ivLoader);
        subjectsBeanRVList = new ArrayList<SubjectsBean>();
        initView();
        presenter.initData();
    }

    private void initView() {
        adapter = new MovieFutureAdapter(R.layout.ftagment_futuremovie_item, subjectsBeanRVList, context);
        rvMovie.setLayoutManager(new LinearLayoutManager(context));
        rvMovie.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SubjectsBean subjectsBean = subjectsBeanRVList.get(position);
                myStartActivity(context,MovieValueActivity.class,"MovieValu", subjectsBean);
            }
        });

    }

    @Override
    public String getTiele() {
        return "即将上映";
    }

    @Override
    public void onStop() {
        super.onStop();
        loaderAnim.stopAnim();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        loaderAnim.stopAnim();
//        unbinder.unbind();
    }

    @Override
    public void loaderAnimStar() {
loaderAnim.starAnim();
    }

    @Override
    public void loaderAnimStop() {
  loaderAnim.stopAnim();
    }

    @Override
    public void notifyData(MovieFuture data) {
        subjectsBeanRVList.addAll(data.getSubjects());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDiao() {

    }
}
