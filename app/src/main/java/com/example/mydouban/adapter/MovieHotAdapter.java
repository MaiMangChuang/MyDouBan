package com.example.mydouban.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.gifdecoder.GifHeader;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mydouban.R;
import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.util.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/22 23:16
 */
public class MovieHotAdapter extends BaseQuickAdapter<SubjectsBean, MovieHotAdapter.MovieHotHolder> {
    Context context;
    List<SubjectsBean> data;

    @NonNull
    @Override
    public List<SubjectsBean> getData() {
        return data;
    }

    public void setData(List<SubjectsBean> data) {
        this.data = data;
    }

    public MovieHotAdapter(int layoutResId, @Nullable List<SubjectsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.data=data;
    }

    @Override
    protected void convert(MovieHotHolder helper, SubjectsBean item) {
        helper.rbMovieGrade.setRating((float)item.getRating().getAverage()/2);
        helper.tvMovieTiele.setText(item.getTitle());
        GlideUtil.showGlide(context,item.getImages().getSmall(),helper.ivMovieImage);
    }

    public static class MovieHotHolder extends BaseViewHolder {
        @BindView(R.id.iv_movieImage)
        ImageView ivMovieImage;
        @BindView(R.id.rb_movieGrade)
        AppCompatRatingBar rbMovieGrade;
        @BindView(R.id.tv_movieTiele)
        TextView tvMovieTiele;

        public MovieHotHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }
}
