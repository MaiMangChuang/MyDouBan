package com.example.mydouban.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mydouban.R;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.util.GlideUtil;
import com.example.mydouban.util.ProjectUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/25 13:52
 */
public class MovieFutureAdapter extends BaseQuickAdapter<SubjectsBean, MovieFutureAdapter.MovieFutureHolder> {
    Context context;


    public MovieFutureAdapter(int layoutResId, @Nullable List<SubjectsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(MovieFutureHolder helper, SubjectsBean item) {
        helper.tvMovieType.setText( "类型："+ProjectUtil.clean(item.getGenres().toString()));
        helper.tvMovieDirectors.setText("导演：" +item.getDirectors().get(0).getName());
        helper.tvMovieTitle.setText(item.getTitle());
        helper.tvMovieOriginalTitle.setText("原名：" +item.getOriginal_title());
        helper.tvMovieCasts.setText("演员："+listToString(item.getCasts(),3));
        GlideUtil.showGlide(context,item.getImages().getSmall(),helper.ivMovieImages);
    }



    public static class MovieFutureHolder extends BaseViewHolder {
        @BindView(R.id.tv_movieOriginal_title)
        TextView tvMovieOriginalTitle;
        @BindView(R.id.iv_movieImages)
        ImageView ivMovieImages;
        @BindView(R.id.tv_movieTitle)
        TextView tvMovieTitle;
        @BindView(R.id.tv_movieType)
        TextView tvMovieType;
        @BindView(R.id.tv_movieDirectors)
        TextView tvMovieDirectors;
        @BindView(R.id.tv_movieCasts)
        TextView tvMovieCasts;

        public MovieFutureHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private static String listToString(List<SubjectsBean.CastsBean> list,int number){
        StringBuffer s=new StringBuffer();
        for(int i=0;i<number;i++){
            if(list.size()>i){
                s.append(list.get(i).getName()+",");
            }else {
                break;
            }
        }
        if(s.length()>0){
            return s.toString().substring(0,s.length()-1);
        }else {
            return "暂无演员信息";
        }

    }

}
