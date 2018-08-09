package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieFutureAdapter;
import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.presenter.FutureMoviePterImpl;
import com.example.mydouban.ui.activity.MovieValueActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 17:27
 */
public class FutureMovieFragment extends AbstractViewPagerProgressFragment<MovieInter.MoviePterInter> implements MovieInter.MovieViewInter<MovieFuture> {

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    Unbinder unbinder;

    private List<SubjectsBean> subjectsBeanRVList;
    private MovieFutureAdapter adapter;
    private Context context;

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
                showUtil.myStartActivity(MovieValueActivity.class,"MovieValu", subjectsBean);


            }
        });

    }




    @Override
    public void loaderAnimStar() {
   showLoading();
    }

    @Override
    public void loaderAnimStop() {
      showContentView();
    }

    @Override
    public void notifyData(MovieFuture data) {
        subjectsBeanRVList.addAll(data.getSubjects());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDiao() {
showEmptyView();
    }

    @Override
    public String getTitle() {
        return "即将上映";
    }
}
