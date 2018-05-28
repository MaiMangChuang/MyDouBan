package com.example.mydouban.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
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
 * 创建时间：2018/5/28 12:58
 */
public class BookSearchAdapter extends BaseQuickAdapter<Book.BooksBean, BookSearchAdapter.BookHolder> {
    private Context context;
    private List<Book.BooksBean> data;
    public BookSearchAdapter(int layoutResId, @Nullable List<Book.BooksBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
        this.data=data;
    }

    @Override
    protected void convert(BookSearchAdapter.BookHolder helper, Book.BooksBean item) {
        helper.tvBookTiele.setText(item.getTitle());
        float f=  Float.parseFloat(item.getRating().getAverage());
        helper.ratingBar.setRating(f/2);
        helper.tvNumber.setText("评分：" + item.getRating().getAverage());
        if(item.getAuthor().size()>0){
            helper.tvPersonName.setText("作者：" + item.getAuthor().get(0));
        }else {
            helper.tvPersonName.setText("作者：暂无信息");
        }
        helper.tvYear.setText("出版日期：" + item.getPubdate());
        String originTitle = item.getOrigin_title().length() < 1 ? item.getTitle() : item.getOrigin_title();
        helper.tvBookOriginTitle.setText("原名：" + originTitle);
        GlideUtil.showGlide(context,item.getImage(),helper.ivBookImage);
    }



    public   static class BookHolder extends BaseViewHolder {
        @BindView(R.id.iv_bookImage)
        ImageView ivBookImage;
        @BindView(R.id.tv_bookTiele)
        TextView tvBookTiele;
        @BindView(R.id.tv_personName)
        TextView tvPersonName;
        @BindView(R.id.tv_year)
        TextView tvYear;
        @BindView(R.id.tv_number)
        TextView tvNumber;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.tv_bookOriginTitle)
        TextView tvBookOriginTitle;


        public BookHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
