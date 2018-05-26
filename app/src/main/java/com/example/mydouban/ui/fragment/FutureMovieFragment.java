package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieFutureAdapter;
import com.example.mydouban.adapter.MovieHotAdapter;
import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 17:27
 */
public class FutureMovieFragment extends BaseFragment {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_futuremovie, container, false);
        unbinder = ButterKnife.bind(this, view);
        subjectsBeanRVList = new ArrayList<SubjectsBean>();
        initView();
        httpData();
        return view;
    }

    private void initView() {
        adapter=new MovieFutureAdapter(R.layout.ftagment_futuremovie_item,subjectsBeanRVList,context);
        rvMovie.setLayoutManager(new LinearLayoutManager(context));
        rvMovie.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SubjectsBean subjectsBean = subjectsBeanRVList.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("MovieValu", subjectsBean);
                Intent intent = new Intent(context, MovieValueActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    private void httpData(){
        HttpUtil.getRetrofit().getFutureMovies() .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).map(new Func1<MovieFuture, List<SubjectsBean>>() {
            @Override
            public List<SubjectsBean> call(MovieFuture movieFuture) {
                return  movieFuture.getSubjects();
            }
        })
                .subscribe(new Subscriber<List<SubjectsBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<SubjectsBean> subjectsBeanArrayList) {
                subjectsBeanRVList.addAll(subjectsBeanArrayList);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public String getTiele() {
        return "即将上映";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
