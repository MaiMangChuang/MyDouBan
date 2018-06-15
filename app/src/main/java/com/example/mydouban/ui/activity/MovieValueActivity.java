package com.example.mydouban.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydouban.R;
import com.example.mydouban.bean.MovieValue;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.presenter.MoviePterImpl;
import com.example.mydouban.util.GlideUtil;
import com.example.mydouban.util.HttpUtil;
import com.example.mydouban.util.LoaderAnim;
import com.example.mydouban.util.ProjectUtil;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/20 0:12
 */
public class MovieValueActivity extends BaseAppCompatActivity<MovieInter.MoviePterInter> implements MovieInter.MovieViewInter<MovieValue> {
    @BindView(R.id.iv_movieImages)
    ImageView ivMovieImages;
    @BindView(R.id.tv_movieTiele)
    TextView tvMovieTiele;
    @BindView(R.id.tv_movieTyte)
    TextView tvMovieTyte;
    @BindView(R.id.tv_movieName)
    TextView tvMovieName;
    @BindView(R.id.tv_movieCountry)
    TextView tvMovieCountry;
    @BindView(R.id.tv_movieTime)
    TextView tvMovieTime;
    @BindView(R.id.tv_movieGrade)
    TextView tvMovieGrade;
    @BindView(R.id.rb_movieGrade)
    AppCompatRatingBar rbMovieGrade;
    @BindView(R.id.tv_commentNumber)
    TextView tvCommentNumber;
    @BindView(R.id.tv_movieValue)
    TextView tvMovieValue;
    SubjectsBean subjectsBean;
    @BindView(R.id.iv_black)
    ImageView ivBlack;
    @BindView(R.id.iv_enshrine)
    ImageView ivEnshrine;
    @BindView(R.id.fab_web)
    FloatingActionButton fabWeb;
    String movieUrl;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    private LoaderAnim loaderAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subjectsBean = getIntent().getParcelableExtra("MovieValu");
        String movieId = subjectsBean.getId();
        loaderAnim = new LoaderAnim(ivLoader);
        presenter = new MoviePterImpl(this, movieId);
        presenter.initData();
    }


    @Override
    public int getLayoutResID() {
        return R.layout.activity_movie_value;
    }

    @OnClick({R.id.iv_black, R.id.iv_enshrine, R.id.fab_web})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_black:
                myFinish();
                break;
            case R.id.iv_enshrine:
                showUtil.showTose("点击了收藏");
                break;
            case R.id.fab_web:
                Intent intent = new Intent(this, MovieWebActivity.class);
                intent.putExtra("movieUrl", movieUrl);
                startActivity(intent);
                break;
        }
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
    public void notifyData(MovieValue movieValue) {
        movieUrl = movieValue.getMobile_url();
        double movieAverage = movieValue.getRating().getAverage();
        tvMovieTiele.setText(movieValue.getTitle());
        tvMovieName.setText("原名：" + movieValue.getOriginal_title());
        tvMovieGrade.setText(String.valueOf(movieAverage));
        tvMovieTyte.setText("电影类型：" + ProjectUtil.clean(movieValue.getGenres().toString()));
        tvMovieCountry.setText("上映国家：" + ProjectUtil.clean(movieValue.getCountries().toString()));
        tvMovieTime.setText("上映时间：" + movieValue.getYear());
        tvMovieValue.setText(movieValue.getSummary());
        tvCommentNumber.setText(movieValue.getRatings_count() + "人评价");
        rbMovieGrade.setRating((float) movieAverage / 2);
        GlideUtil.showGlide(MovieValueActivity.this, movieValue.getImages().getLarge(), ivMovieImages);
    }

    @Override
    public void showDiao() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
