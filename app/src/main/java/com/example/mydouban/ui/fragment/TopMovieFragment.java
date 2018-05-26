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
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieTopAdapter;
import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.LoaderAnim;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 16:15
 */
public class TopMovieFragment extends BaseFragment {
    Context context;
    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    Unbinder unbinder;
    int start;
    int count = 20;
    List<SubjectsBean> list;
    MovieTopAdapter adapter;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    private boolean isAniam=true;
    private LoaderAnim loaderAnim;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        start=0;
        list = new ArrayList<SubjectsBean>();
        adapter = new MovieTopAdapter(R.layout.ftagment_topmovie_item, list, context);

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        unbinder = ButterKnife.bind(this, view);
        loaderAnim=new LoaderAnim(ivLoader);
        rvMovie.setLayoutManager(new LinearLayoutManager(context));
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvMovie.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (start >= 250) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        } else {
                            httpData();
                            adapter.loadMoreComplete();

                        }
                    }

                }, 100);
            }
        }, rvMovie);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
               SubjectsBean subjectsBean = list.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("MovieValu", subjectsBean);
                Intent intent = new Intent(context, MovieValueActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        rvMovie.setAdapter(adapter);
        httpData();
        return view;
    }


    @Override
    public String getTiele() {
        return "TOP250";
    }
    private void httpData() {
        if(isAniam){
            loaderAnim.starAnim();
        }

        HttpUtil.getRetrofit().getTopMovies(start, count).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MovieTop250>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                loaderAnim.stopAnim();
                Log.e("TAG", "e " + e.toString());
            }

            @Override
            public void onNext(MovieTop250 movieTop250) {
                int listSize=list.size();
                if(listSize<250){
                    if(listSize+20<=250){
                        list.addAll(movieTop250.getSubjects());
                        start += 20;
                    }else {
                        list.addAll(movieTop250.getSubjects().subList(0,250-listSize));
                        start +=250-listSize;
                    }
                    Log.e("TAGS", "listSize: " +listSize+"start:"+start);
                    adapter.notifyItemRangeChanged(start, start + 20);

                }

                if(isAniam){
                    loaderAnim.stopAnim();
                    isAniam=false;
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }

    @Override
    public void onStop() {
        super.onStop();

        loaderAnim.stopAnim();
    }
}
