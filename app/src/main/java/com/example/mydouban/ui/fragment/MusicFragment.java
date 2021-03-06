package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MusicAdapter;
import com.example.mydouban.bean.Music;
import com.example.mydouban.inte.MusicInter;
import com.example.mydouban.presenter.MusicPterImpl;
import com.example.mydouban.ui.activity.MusicWebActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/28 14:39
 */
public class MusicFragment extends AbstractViewPagerProgressFragment<MusicPterImpl> implements MusicInter.MusicViewInter<Music> {
    @BindView(R.id.rv_music)
    RecyclerView rvMusic;
    private String title;
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
        musicBeanList = new ArrayList<>();
    }



    @Override
    public int getLayoutResID() {
        return R.layout.fragment_music;
    }

    @Override
    public void init() {
        musicBeanList = new ArrayList<>();
        presenter = new MusicPterImpl(this, title);
        initView();
        presenter.initData();
    }


    private void initView() {

        adapter = new MusicAdapter(R.layout.fragment_music_item, musicBeanList, getActivity().getApplicationContext());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Music.MusicsBean musicsBean = musicBeanList.get(position);
                showUtil.myStartActivity(MusicWebActivity.class,"musicUrl", musicsBean.getAlt());
            }
        });
        rvMusic.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rvMusic.setAdapter(adapter);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvMusic.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (musicBeanList.size() > 300) {
                            //数据全部加载完毕
                            if(adapter!=null){
                                adapter.loadMoreEnd();
                            }
                        } else {
                            if(presenter!=null){
                                presenter.moreData();
                            }
                            if(adapter!=null){
                                adapter.loadMoreComplete();
                            }

                        }
                    }

                }, 500);
            }
        }, rvMusic);

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
    public void notifyData(Music data) {
        musicBeanList.addAll(data.getMusics());
        adapter.notifyDataSetChanged();
    }



    @Override
    public void showDiao() {
showEmptyView();
    }

    @Override
    public String getTitle() {
        return title;
    }


}
