package com.example.mydouban.presenter;

import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.model.BookValueModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:19
 */
public class BookValuePterImpl implements BookInter.BookPterInter {
    private BookInter.BookViewInter<Book> view;
    private BookInter.BookModInter<Book> modle;


    public BookValuePterImpl(BookInter.BookViewInter<Book> view, String tag) {
        this.view = view;
        modle = new BookValueModelImpl(tag);

    }

    @Override
    public void initData() {
        modle.getData(new DataCallBack<Book>() {
            @Override
            public void dataLose(String message) {
                view.loaderAnimStop();
                view.showDiao();
            }

            @Override
            public void dataSucceed(Book data) {
                view.loaderAnimStop();
                view.notifyData(data);
            }
        });
    }

    @Override
    public void moreData() {

    }
}
