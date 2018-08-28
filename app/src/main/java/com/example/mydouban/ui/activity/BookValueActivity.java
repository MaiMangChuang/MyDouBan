package com.example.mydouban.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mydouban.R;
import com.example.mydouban.adapter.BookAdapter;
import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.presenter.BookPterImpl;
import com.example.mydouban.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Administrator
 */
public class BookValueActivity extends AbstractProgressActivity<BookInter.BookPterInter> implements BookInter.BookViewInter<Book> {

    @BindView(R.id.iv_bookImage)
    ImageView ivBookImage;
    @BindView(R.id.tv_bookTiele)
    TextView tvBookTiele;
    @BindView(R.id.tv_personName)
    TextView tvPersonName;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.tv_bookValue)
    TextView tvBookValue;
    @BindView(R.id.rv_book)
    RecyclerView rvBook;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.tv_bookOriginTitle)
    TextView tvBookOriginTitle;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tv_publisher)
    TextView tvPublisher;
    @BindView(R.id.tv_web)
    TextView tvWeb;
    @BindView(R.id.iv_black)
    ImageView ivBlack;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.iv_enshrine)
    ImageView ivEnshrine;
    @BindView(R.id.text)
    TextView text;
    private Book.BooksBean booksBean;
    private List<Book.BooksBean> booksBeans;
    private BookAdapter adapter;


    @Override
    public int getLayoutResID() {
        return R.layout.activity_book_value;
    }

    @Override
    public void init() {
        booksBean = getIntent().getParcelableExtra("BooksBean");
        booksBeans = new ArrayList<Book.BooksBean>();
        adapter = new BookAdapter(R.layout.about_book_item, booksBeans, this);
        presenter = new BookPterImpl(this, booksBean.getAuthor().get(0));
        presenter.initData();
        rvBook.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        rvBook.setAdapter(adapter);
        tvBookTiele.setText(booksBean.getTitle());
        tvBookValue.setText(booksBean.getSummary());
        tvNumber.setText("评分：" + booksBean.getRating().getAverage());
        tvPersonName.setText("作者：" + booksBean.getAuthor().get(0));
        tvYear.setText("出版日期：" + booksBean.getPubdate());
        String originTitle = booksBean.getOrigin_title().length() < 1 ? booksBean.getTitle() : booksBean.getOrigin_title();
        tvBookOriginTitle.setText("原名：" + originTitle);
        tvPublisher.setText("出版社：" + booksBean.getPublisher());
        float average = Float.parseFloat(booksBean.getRating().getAverage());
        ratingBar.setRating(average / 2);
        GlideUtil.showGlide(this, booksBean.getImages().getSmall(), ivBookImage);
        showUtil.showLog(booksBean);
    }


    @OnClick({R.id.iv_black, R.id.tv_web})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_black:
             finish();
                break;
            case R.id.tv_web:
                 showUtil.myStartActivity(BookWebActivity.class, "bookUrl", booksBean.getAlt());
                break;
            default:
                break;
        }
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
    public void notifyData(Book data) {
        if (data.getBooks().size() > 0) {
            booksBeans.addAll(data.getBooks());
            adapter.notifyDataSetChanged();
        } else {
            text.setVisibility(View.GONE);
        }
    }

    @Override
    public void showDiao() {
        showEmptyView();
    }


}
