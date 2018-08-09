package com.example.mydouban.ui.activity;

import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mydouban.R;

import butterknife.BindView;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/21 22:24
 */
public class MovieWebActivity extends AbstractProgressActivity {

    @BindView(R.id.wv_movie)
    WebView wvMovie;
    String movieUrl;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    public int getLayoutResID() {
        return R.layout.activity_movie_web;
    }


    @Override
    public void init() {
        movieUrl = getIntent().getStringExtra("movieUrl");
        toolbar.setNavigationIcon(R.drawable.ic_reply_all);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFinish();
            }
        });
        WebSettings webSettings = wvMovie.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvMovie.setWebViewClient(webViewClient);
        wvMovie.loadUrl(movieUrl);
    }

    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            showLoading();
            showUtil.showLog("页面加载完成");
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
            showContentView();
            showUtil.showLog("页面开始加载");
        }


    };

    @Override
    protected void onStop() {
        super.onStop();
        showEmptyView();
    }
}
