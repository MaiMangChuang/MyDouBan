package com.example.mydouban.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mydouban.R;
import com.example.mydouban.SearchInter.SearchManges;
import com.example.mydouban.adapter.BookAdapter;
import com.example.mydouban.adapter.BookSearchAdapter;
import com.example.mydouban.adapter.MovieFutureAdapter;
import com.example.mydouban.adapter.MovieHotAdapter;
import com.example.mydouban.adapter.MusicAdapter;
import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.Music;
import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.SearchCall;
import com.example.mydouban.util.HttpUtil;
import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchlnterActivity extends BaseAppCompatActivity {

    @BindView(R.id.et_searchlnter)
    EditText etSearchlnter;
    @BindView(R.id.rv_searchlnter)
    RecyclerView rvSearchlnter;
    String tvValue;
    boolean is;
    Timer timer ;
    private Handler mHandler;
   private BaseQuickAdapter adapter;
    private SearchCall mSearchCall;
    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvValue="";
         initAdapter();
        timer = new Timer();
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(tvValue!=etSearchlnter.getText().toString()&&etSearchlnter.getText().toString()!=""){
                    httpData();
                }
            }
        };
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message=new Message();
                message.what=0;
                mHandler.sendMessage(message);
            }
        },3000,2000);

    }

    private void initAdapter() {
        list=new ArrayList();
        mSearchCall=SearchManges.get(SearchManges.nowSearchCall);
        rvSearchlnter.setLayoutManager(new LinearLayoutManager(this));
        switch (SearchManges.nowSearchCall){
            case "MovieSearch" :
                adapter=new MovieFutureAdapter(R.layout.ftagment_futuremovie_item,list,this);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        SubjectsBean subjectsBean = (SubjectsBean) list.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("MovieValu", subjectsBean);
                        Intent intent = new Intent(SearchlnterActivity.this, MovieValueActivity.class);
                        intent.putExtras(bundle);
                        SearchlnterActivity.this.startActivity(intent);
                    }
                });
                break;
            case "BookSearch":
                adapter=new BookSearchAdapter(R.layout.search_book_item,list,this);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Book.BooksBean booksBean = (Book.BooksBean) list.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("BooksBean", booksBean);
                        Intent intent = new Intent(SearchlnterActivity.this, BookValueActivity.class);
                        intent.putExtras(bundle);
                        SearchlnterActivity.this.startActivity(intent);
                    }
                });
                break;

            case "MusicSearch":
                adapter=new MusicAdapter(R.layout.fragment_music_item,list,this);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Music.MusicsBean musicsBean = (Music.MusicsBean) list.get(position);
                        Intent intent = new Intent(SearchlnterActivity.this, MusicWebActivity.class);
                        intent.putExtra("musicUrl",musicsBean.getAlt());
                        SearchlnterActivity.this.startActivity(intent);
                    }
                });
                break;
        }
        rvSearchlnter.setAdapter(adapter);
    }

    private void httpData() {
        mSearchCall.searchCall(etSearchlnter.getText().toString(),adapter);
        tvValue=etSearchlnter.getText().toString();
    }


    @Override
    public int getLayoutResID() {
        return R.layout.activity_searchlnter;
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer=null;
        mHandler=null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }
}
