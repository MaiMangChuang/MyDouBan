package com.example.mydouban.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mydouban.R;
import com.example.mydouban.bean.Book;
import com.example.mydouban.util.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/26 20:33
 */
public class BookAdapter extends BaseQuickAdapter<Book.BooksBean, BookAdapter.BookHolder> {
private  Context context;
    public BookAdapter(int layoutResId, @Nullable List<Book.BooksBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BookAdapter.BookHolder helper, Book.BooksBean item) {
        helper.tvBookTiele.setText(item.getTitle());
       float f=  Float.parseFloat(item.getRating().getAverage());
        helper.rbMovieGrade.setRating(f/2);
        GlideUtil.showGlide(context,item.getImage(),helper.ivBookImage);
    }

   public   static class BookHolder extends BaseViewHolder {
        @BindView(R.id.iv_bookImage)
        ImageView ivBookImage;
        @BindView(R.id.rb_movieGrade)
        AppCompatRatingBar rbMovieGrade;
        @BindView(R.id.tv_bookTiele)
        TextView tvBookTiele;

        public BookHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
