package com.example.mydouban.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mydouban.R;
import com.example.mydouban.bean.Book;

public class BookValueActivity extends BaseAppCompatActivity {
    private Book.BooksBean booksBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        booksBean = getIntent().getParcelableExtra("BooksBean");
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_book_value;
    }
}
