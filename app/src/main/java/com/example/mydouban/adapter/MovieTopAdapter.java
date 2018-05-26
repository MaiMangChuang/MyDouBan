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
        this.context=context;
    }

    @Override
    protected void convert(MovieTop250Holder helper, SubjectsBean item) {
        // 评分
        String ratingAverage = String.valueOf(item.getRating().getAverage());
        helper.tvMovieGrade.setText(ratingAverage);
        Log.d(TAG, "评分: " + ratingAverage);
        // 影片类型
        String genres = item.getGenres().toString();
       // String genre = genres.substring(1, genres.length() - 1);
        helper.tvMovieTytpe.setText(ProjectUtil.clean(genres));
        // 影片标题
        String title = item.getTitle();
        helper.tvMovieTiele.setText(title);
        Log.d(TAG, "影片标题: " + title);
        // 主演
       // String castAvatar = item.getCasts().get(0).getAvatars().getMedium();
        String castName="暂无信息";
        String castId="暂无信息";
        if(item.getCasts().size()>=1){
            castName = item.getCasts().get(0).getName();
            castId = item.getCasts().get(0).getId();
        }
        helper.tvMovieActor.setText(castName);
      //  Log.d("TAG", "主演头像: " + castAvatar);
        Log.d("TAG", "主演中文名: " + castName);
        Log.d("TAG", "主演 ID: " + castId);
       //排名
        if(helper.getLayoutPosition()+1>=100){
            helper.tvNumber.setTextSize(14);
        }else {
            helper.tvNumber.setTextSize(18);
        }
        String movieNumber =String.valueOf(helper.getLayoutPosition()+1);
        helper.tvNumber.setText(movieNumber+".");


        // 影片海报
        String image = item.getImages().getMedium();
        Log.d("TAG", "影片海报: " + image);
        GlideUtil.showGlide(context,image,helper.ivMovieImages);
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
