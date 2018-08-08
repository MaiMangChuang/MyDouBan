package com.example.mydouban.ui.activity;

import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mydouban.R;

import butterknife.BindView;


public class BookWebActivity extends AbstractProgressActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.wv_book)
    WebView wvBook;
    String movieUrl;

//    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        movieUrl = getIntent().getStringExtra("bookUrl");
////    }


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
        movieUrl = getIntent().getStringExtra("bookUrl");
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
    public int getLayoutResID() {
        return R.layout.activity_book_web;
    }
}
