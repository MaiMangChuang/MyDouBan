package com.example.mydouban.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.adapter.MovieHotAdapter;
import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.ui.activity.MovieValueActivity;
import com.example.mydouban.util.GlideUtil;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.LoaderAnim;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 16:06
 */
public class HotMovieFragment extends BaseFragment {
    @BindView(R.id.banner)
    com.youth.banner.Banner banner;
    @BindView(R.id.rv_hotMovie)
    RecyclerView rvHotMovie;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    Unbinder unbinder;
    private Context context;
    private ArrayList<SubjectsBean> subjectsBeanBannerList;
    private ArrayList<SubjectsBean> subjectsBeanRVList;
    private MovieHotAdapter adapter;
    private final int BANNERSIZE = 4;
    private LoaderAnim loaderAnim;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotmovie, container, false);
        unbinder = ButterKnife.bind(this, view);
        loaderAnim=new LoaderAnim(ivLoader);
        subjectsBeanBannerList = new ArrayList<SubjectsBean>();
        subjectsBeanRVList = new ArrayList<SubjectsBean>();
        init();
        httpData();
        return view;
    }

    private void init() {
        adapter = new MovieHotAdapter(R.layout.ftagment_hotmovie_item, subjectsBeanRVList, context);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                GlideUtil.showGlide(context, (String) path, imageView);
            }
        });
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置轮播时间
        banner.setDelayTime(4000);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    private void httpData() {
      loaderAnim.starAnim();
        HttpUtil.getRetrofit().getHotMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).map(new Func1<MovieHot, List<SubjectsBean>>() {
            @Override
            public List<SubjectsBean> call(MovieHot movieHot) {
                return movieHot.getSubjects();
            }
        }).subscribe(new Subscriber<List<SubjectsBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("HotMovieFragment", "e " + e.toString());
                loaderAnim.stopAnim();
            }

            @Override
            public void onNext(List<SubjectsBean> subjectsBeanList) {
                for (int i = 0; i < BANNERSIZE; i++) {
                    SubjectsBean subjectsBean = subjectsBeanList.get(i);
                    subjectsBeanBannerList.add(subjectsBean);
                }
                subjectsBeanRVList.addAll(subjectsBeanList.subList(BANNERSIZE, subjectsBeanList.size()));
                startBanner();
                initRV();
                loaderAnim.stopAnim();
            }
        });
    }

    private void initRV() {
        rvHotMovie.setLayoutManager(new GridLayoutManager(context, 3));
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
        rvHotMovie.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void startBanner() {
        ArrayList<String> imageList = new ArrayList<String>();
        ArrayList<String> titlesList = new ArrayList<String>();
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
    public String getTiele() {
        return "正在热播";
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
