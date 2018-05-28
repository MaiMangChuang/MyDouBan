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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MusicAdapter;
import com.example.mydouban.bean.Music;
import com.example.mydouban.ui.activity.MusicWebActivity;
import com.example.mydouban.ui.activity.SearchlnterActivity;
import com.example.mydouban.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/28 14:39
 */
public class MusicFragment extends BaseFragment {
    @BindView(R.id.rv_music)
    RecyclerView rvMusic;
    private String title;
    private Context context;
    private int start;
    private int count;
    private List<Music.MusicsBean> musicBeanList;
    private MusicAdapter adapter;
    Unbinder unbinder;

    public void setTitle(String title) {
        this.title = title;
    }

    public static MusicFragment newInstance(String title) {
        MusicFragment mf = new MusicFragment();
        mf.setTitle(title);
        return mf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        musicBeanList = new ArrayList<>();
        start = 0;
        count = 20;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        unbinder = ButterKnife.bind(this, view);
        musicBeanList=new ArrayList<>();

        initView();
        httpData();
        return view;
    }

    private void httpData() {
        HttpUtil.getRetrofit().getTagMusic(title,start,count).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Music>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Music music) {
                musicBeanList.addAll(music.getMusics());
                adapter.notifyDataSetChanged();
                start+=20;
            }
        });

    }

    private void initView() {
        adapter=new MusicAdapter(R.layout.fragment_music_item,musicBeanList,context);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Music.MusicsBean musicsBean = musicBeanList.get(position);
                Intent intent = new Intent(context, MusicWebActivity.class);
                intent.putExtra("musicUrl",musicsBean.getAlt());
                MusicFragment.this.startActivity(intent);
            }
        });
        rvMusic.setLayoutManager(new LinearLayoutManager(context));
        rvMusic.setAdapter(adapter);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvMusic.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (musicBeanList.size()%20!=0) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        } else {
                            httpData();
                            adapter.loadMoreComplete();

                        }
                    }

                }, 100);
            }
        }, rvMusic);

    }

    @Override
    public String getTiele() {
        return title;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
