package com.example.mydouban.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mydouban.R;
import com.example.mydouban.util.LoaderAnim;

import butterknife.BindView;

public class MusicWebActivity extends BaseAppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wv_music)
    WebView wvMusic;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    String musicUrl;
    private LoaderAnim loaderAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicUrl = getIntent().getStringExtra("musicUrl");
        loaderAnim=new LoaderAnim(ivLoader);
        init();
    }
    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            loaderAnim.stopAnim();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
            loaderAnim.starAnim();
        }



    };

    private void init() {
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
    protected void onStop() {
        super.onStop();
        loaderAnim.stopAnim();
    }
    @Override
    public int getLayoutResID() {
        return R.layout.activity_music_web;
    }
}
