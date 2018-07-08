package com.example.mydouban.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mydouban.R;
import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.util.GlideUtil;
import com.example.mydouban.util.ProjectUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 23:59
 */
public class MovieTopAdapter extends BaseQuickAdapter<SubjectsBean, MovieTopAdapter.MovieTop250Holder> {
    private final Context context;

    public MovieTopAdapter(int layoutResId, @Nullable List<SubjectsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(MovieTop250Holder helper, SubjectsBean item) {

        String ratingAverage = String.valueOf(item.getRating().getAverage());
        helper.tvMovieGrade.setText(ratingAverage);
        String genres = item.getGenres().toString();
        helper.tvMovieTytpe.setText(ProjectUtil.clean(genres));
        String title = item.getTitle();
        helper.tvMovieTiele.setText(title);
        if (item.getCasts().size() > 0) {
            helper.tvMovieActor.setText(item.getCasts().get(0).getName());
        } else {
            helper.tvMovieActor.setText(R.string.Lost);
        }


        if (helper.getLayoutPosition() + 1 >= 100) {
            helper.tvNumber.setTextSize(14);
        } else {
            helper.tvNumber.setTextSize(18);
        }
        String movieNumber = String.valueOf(helper.getLayoutPosition() + 1);
        helper.tvNumber.setText(movieNumber + ".");


        String image = item.getImages().getMedium();
        GlideUtil.showGlide(context, image, helper.ivMovieImages);
    }

    static class MovieTop250Holder extends BaseViewHolder {
        @BindView(R.id.tv_number)
        TextView tvNumber;
        @BindView(R.id.iv_movieImages)
        ImageView ivMovieImages;
        @BindView(R.id.tv_movieTiele)
        TextView tvMovieTiele;
        @BindView(R.id.tv_movieTytpe)
        TextView tvMovieTytpe;
        @BindView(R.id.tv_movieActor)
        TextView tvMovieActor;
        @BindView(R.id.tv_movieGrade)
        TextView tvMovieGrade;

        public MovieTop250Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }


}
