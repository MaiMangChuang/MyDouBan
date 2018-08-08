package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MusicAdapter;
import com.example.mydouban.bean.Music;
import com.example.mydouban.inte.MusicInter;
import com.example.mydouban.presenter.MusicPterImpl;
import com.example.mydouban.ui.activity.MusicWebActivity;
import com.example.mydouban.util.LoaderAnim;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/28 14:39
 */
public class MusicFragment extends AbstractViewPagerFragment<MusicPterImpl> implements MusicInter.MusicViewInter<Music> {
    @BindView(R.id.rv_music)
    RecyclerView rvMusic;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    private String title;
    private Context context;
    private List<Music.MusicsBean> musicBeanList;
    private MusicAdapter adapter;
    private LoaderAnim loaderAnim;
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
    }



    @Override
    public int getLayoutResID() {
        return R.layout.fragment_music;
    }

    @Override
    public void init() {
        musicBeanList = new ArrayList<>();
        presenter = new MusicPterImpl(this, title);
        loaderAnim=new LoaderAnim(ivLoader);
        initView();
        presenter.initData();
    }


    private void initView() {
        adapter = new MusicAdapter(R.layout.fragment_music_item, musicBeanList, context);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Music.MusicsBean musicsBean = musicBeanList.get(position);
                Intent intent = new Intent(context, MusicWebActivity.class);
                intent.putExtra("musicUrl", musicsBean.getAlt());
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
                        if (musicBeanList.size() > 300) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        } else {
                            presenter.moreData();
                            adapter.loadMoreComplete();

                        }
                    }

                }, 800);
            }
        }, rvMusic);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onStop() {
        loaderAnim.stopAnim();
        super.onStop();
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
    public void notifyData(Music data) {
        musicBeanList.addAll(data.getMusics());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDiao() {

    }

    @Override
    public String getTitle() {
        return title;
    }
}
