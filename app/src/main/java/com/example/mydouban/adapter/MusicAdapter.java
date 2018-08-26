package com.example.mydouban.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mydouban.R;
import com.example.mydouban.bean.Music;
import com.example.mydouban.util.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/28 14:57
 */
public class MusicAdapter extends BaseQuickAdapter<Music.MusicsBean, MusicAdapter.MusicHolder> {
    private Context context;
    private List<Music.MusicsBean> data;

    public MusicAdapter(int layoutResId, @Nullable List<Music.MusicsBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    protected void convert(MusicHolder helper, Music.MusicsBean item) {
        helper.tvMusicTitle.setText(item.getTitle());
        if(item.getAuthor().size()>0){
            helper.tvMusicAuthor.setText(item.getAuthor().get(0).getName());
        }else {
            helper.tvMusicAuthor.setText(R.string.Lost);
        }

        String average = item.getRating().getAverage();
        helper.tvMusicGrade.setText(average);
        helper.rbMovieGrade.setRating(Float.parseFloat(average) / 2);
        GlideUtil.showGlide(context, item.getImage(), helper.civImage);
    }



    public class MusicHolder extends BaseViewHolder {
        @BindView(R.id.civ_image)
        CircleImageView civImage;
        @BindView(R.id.tv_musicTitle)
        TextView tvMusicTitle;
        @BindView(R.id.tv_musicGrade)
        TextView tvMusicGrade;
        @BindView(R.id.tv_musicAuthor)
        TextView tvMusicAuthor;
        @BindView(R.id.rb_movieGrade)
        RatingBar rbMovieGrade;

        public MusicHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
