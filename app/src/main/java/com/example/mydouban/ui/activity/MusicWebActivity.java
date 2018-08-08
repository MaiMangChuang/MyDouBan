package com.example.mydouban.ui.activity;

import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mydouban.R;

import butterknife.BindView;

public class MusicWebActivity extends AbstractProgressActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wv_music)
    WebView wvMusic;
    String musicUrl;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            showContentView();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
       showLoading();
        }



    };

    @Override
    public void init() {
        musicUrl = getIntent().getStringExtra("musicUrl");
        toolbar.setNavigationIcon(R.drawable.ic_reply_all);
        toolbar.setTitle("豆瓣音乐");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFinish();
            }
        });
        WebSettings webSettings = wvMusic.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvMusic.setWebViewClient(webViewClient);
        wvMusic.loadUrl(musicUrl);
    }


    @Override
    public int getLayoutResID() {
        return R.layout.activity_music_web;
    }
}
