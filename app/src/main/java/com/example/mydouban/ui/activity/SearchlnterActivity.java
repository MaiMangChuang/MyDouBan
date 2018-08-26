package com.example.mydouban.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.searchinter.SearchManges;
import com.example.mydouban.adapter.BookSearchAdapter;
import com.example.mydouban.adapter.MovieFutureAdapter;
import com.example.mydouban.adapter.MusicAdapter;
import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.Music;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.SearchCall;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.functions.Action1;

public class SearchlnterActivity extends BaseAppCompatActivity {

    @BindView(R.id.et_searchlnter)
    EditText etSearchlnter;
    @BindView(R.id.rv_searchlnter)
    RecyclerView rvSearchlnter;
    private BaseQuickAdapter adapter;
    private SearchCall mSearchCall;
    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
        RxTextView.textChanges(etSearchlnter).debounce(600, TimeUnit.MILLISECONDS).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                if (!"".equals(charSequence.toString())) {
                    httpData(charSequence.toString());
                }
            }
        });

    }

    private void initAdapter() {
        list = new ArrayList();
        mSearchCall = SearchManges.get(SearchManges.nowSearchCall);
        rvSearchlnter.setLayoutManager(new LinearLayoutManager(this));
        switch (SearchManges.nowSearchCall) {
            case SearchManges.MOVIESEARCH:
                adapter = new MovieFutureAdapter(R.layout.ftagment_futuremovie_item, list, this);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        SubjectsBean subjectsBean = (SubjectsBean) list.get(position);
                       showUtil.myStartActivity(MovieValueActivity.class, "MovieValu", subjectsBean);
                    }
                });
                break;
            case SearchManges.BOOKSEARCH:
                adapter = new BookSearchAdapter(R.layout.search_book_item, list, this);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Book.BooksBean booksBean = (Book.BooksBean) list.get(position);
                        showUtil.myStartActivity(BookValueActivity.class, "BooksBean", booksBean);
                    }
                });
                break;

            case SearchManges.MUSICSEARCH:
                adapter = new MusicAdapter(R.layout.fragment_music_item, list, this);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Music.MusicsBean musicsBean = (Music.MusicsBean) list.get(position);
                        showUtil.myStartActivity(MusicWebActivity.class, "musicUrl", musicsBean.getAlt());
                    }
                });
                break;
            default:
                break;
        }
        rvSearchlnter.setAdapter(adapter);
    }

    private void httpData(String value) {
        mSearchCall.searchCall(value, adapter);
    }


    @Override
    public int getLayoutResID() {
        return R.layout.activity_searchlnter;
    }


}
