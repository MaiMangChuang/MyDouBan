package com.example.mydouban.presenter;

import com.example.mydouban.bean.Book;
import com.example.mydouban.inte.BasePresenterInter;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.model.BookValueModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 2:19
 */
public class BookValuePterImpl extends BasePresenter<BookInter.BookViewInter<Book>,BookInter.BookModInter<Book>> implements BookInter.BookPterInter {



    public BookValuePterImpl(BookInter.BookViewInter<Book> view, String tag) {
        super(view,new BookValueModelImpl(tag));


    }

    @Override
    public void initData() {
        mModel.getData(new DataCallBack<Book>() {
            @Override
            public void dataLose(String message) {
                mView.loaderAnimStop();
                mView.showDiao();
            }

            @Override
            public void dataSucceed(Book data) {
                mView.loaderAnimStop();
                mView.notifyData(data);
            }
        });
    }

    @Override
    public void moreData() {

    }
}
