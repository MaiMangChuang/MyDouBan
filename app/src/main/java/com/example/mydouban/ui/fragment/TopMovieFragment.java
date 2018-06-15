package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieTopAdapter;
import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.presenter.TopMoviePterImpl;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.LoaderAnim;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 16:15
 */
public class TopMovieFragment extends BaseFragment<MovieInter.MoviePterInter> implements MovieInter.MovieViewInter<MovieTop250> {
    Context context;
    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    Unbinder unbinder;
    List<SubjectsBean> list;
    MovieTopAdapter adapter;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    private LoaderAnim loaderAnim;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        presenter=new TopMoviePterImpl(this);
        list = new ArrayList<>();
        adapter = new MovieTopAdapter(R.layout.ftagment_topmovie_item, list, context);
    }



    @Override
    public int getLayoutResID() {
        return R.layout.fragment_movie;
    }

    @Override
    public void init() {
        loaderAnim=new LoaderAnim(ivLoader);
        rvMovie.setLayoutManager(new LinearLayoutManager(context));
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvMovie.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (list.size() >= 250) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        } else {
                            presenter.moreData();
                            adapter.loadMoreComplete();
                        }
                    }

                }, 800);
            }
        }, rvMovie);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SubjectsBean subjectsBean = list.get(position);
                myStartActivity(context, MovieValueActivity.class,"MovieValu", subjectsBean);

            }
        });
        rvMovie.setAdapter(adapter);
        Log.e("TopMovieFragment", "onCreateView: ssssssssssssssssss" );
        presenter.initData();
    }


    @Override
    public String getTiele() {
        return "TOP250";
    }




    @Override
    public void onStop() {
        super.onStop();
        loaderAnim.stopAnim();

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
    public void notifyData(MovieTop250 movieTop250) {
        int listSize=list.size();
        if(listSize<250){
            if(listSize+20<=250){
                list.addAll(movieTop250.getSubjects());
                adapter.notifyItemRangeChanged(list.size()-20, list.size() );
            }else {
                list.addAll(movieTop250.getSubjects().subList(0,250-listSize));
                adapter.notifyItemRangeChanged(list.size()-(250-listSize), list.size() );
            }
        }
    }

    @Override
    public void showDiao() {

    }
}
