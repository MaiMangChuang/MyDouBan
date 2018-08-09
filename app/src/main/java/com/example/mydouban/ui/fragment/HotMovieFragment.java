package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieHotAdapter;
import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.presenter.HotMoviePterImpl;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.GlideUtil;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 16:06
 */
public class HotMovieFragment extends AbstractViewPagerProgressFragment<MovieInter.MoviePterInter> implements MovieInter.MovieViewInter<MovieHot> {
    @BindView(R.id.banner)
    com.youth.banner.Banner banner;
    @BindView(R.id.rv_hotMovie)
    RecyclerView rvHotMovie;

    Unbinder unbinder;
    private Context context;
    private ArrayList<SubjectsBean> subjectsBeanBannerList;
    private ArrayList<SubjectsBean> subjectsBeanRVList;
    private MovieHotAdapter adapter;
    private final int BANNERSIZE = 4;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }


    @Override
    public int getLayoutResID() {
        return R.layout.fragment_hotmovie;
    }

    @Override
    public void init() {
        presenter = new HotMoviePterImpl(this);
        subjectsBeanBannerList = new ArrayList<>();
        subjectsBeanRVList = new ArrayList<>();
        adapter = new MovieHotAdapter(R.layout.ftagment_hotmovie_item, subjectsBeanRVList, context);
        initBanner();
        initRV();
        presenter.initData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

private void initBanner(){
    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
    //设置图片加载器
    banner.setImageLoader(new ImageLoader() {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            GlideUtil.showGlide(context, (String) path, imageView);
        }
    });
    //设置banner动画效果
    banner.setBannerAnimation(Transformer.DepthPage);
    //设置指示器位置（当banner模式中有指示器时）
    banner.setIndicatorGravity(BannerConfig.RIGHT);
banner.setOnBannerListener(new OnBannerListener() {
    @Override
    public void OnBannerClick(int position) {
        SubjectsBean subjectsBean=  subjectsBeanBannerList.get(position);
        showUtil.myStartActivity(MovieValueActivity.class, "MovieValu", subjectsBean);
    }
});
}
    private void initRV() {
         GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
        rvHotMovie.setLayoutManager(gridLayoutManager);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SubjectsBean subjectsBean = subjectsBeanRVList.get(position);
                showUtil.myStartActivity(MovieValueActivity.class, "MovieValu", subjectsBean);
            }
        });
        rvHotMovie.setAdapter(adapter);
    }

    private void startBanner() {
        ArrayList<String> imageList = new ArrayList<>();
        ArrayList<String> titlesList = new ArrayList<>();
        for (SubjectsBean subjectsBean : subjectsBeanBannerList) {
            imageList.add(subjectsBean.getImages().getSmall());
            titlesList.add(subjectsBean.getTitle());
        }
        //设置图片集合
        banner.setImages(imageList);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titlesList);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
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
    public void notifyData(MovieHot data) {
        List<SubjectsBean> subjectsBeans = data.getSubjects();
        for (int i = 0; i < BANNERSIZE; i++) {
            SubjectsBean subjectsBean = subjectsBeans.get(i);
            subjectsBeanBannerList.add(subjectsBean);
        }
        subjectsBeanRVList.addAll(subjectsBeans.subList(BANNERSIZE, subjectsBeans.size()));
        startBanner();
        subjectsBeanRVList.addAll(subjectsBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDiao() {
showEmptyView();
    }

    @Override
    public String getTitle() {
        return "正在热播";
    }
}
