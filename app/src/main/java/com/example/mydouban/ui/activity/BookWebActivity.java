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


public class BookWebActivity extends BaseAppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wv_book)
    WebView wvBook;
    @BindView(R.id.iv_loader)
    ImageView ivLoader;
    String movieUrl;
    private LoaderAnim loaderAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieUrl = getIntent().getStringExtra("bookUrl");
        loaderAnim=new LoaderAnim(ivLoader);
        init();
    }


    private WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            loaderAnim.stopAnim();
            showUtil.showLog("页面加载完成");
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
            loaderAnim.starAnim();
            showUtil.showLog("页面开始加载");
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i("ansen", "拦截url:" + url);
            if (url.equals("http://www.google.com/")) {
                Toast.makeText(BookWebActivity.this, "国内不能访问google,拦截该url", Toast.LENGTH_LONG).show();
                return true;//表示我已经处理过了
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

    };
    private void init() {
        toolbar.setNavigationIcon(R.drawable.ic_reply_all);
        toolbar.setTitle(R.string.BookTiele);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFinish();
            }
        });
        WebSettings webSettings = wvBook.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvBook.setWebViewClient(webViewClient);
        wvBook.loadUrl(movieUrl);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loaderAnim.stopAnim();
    }
    @Override
    public int getLayoutResID() {
        return R.layout.activity_book_web;
    }
}
