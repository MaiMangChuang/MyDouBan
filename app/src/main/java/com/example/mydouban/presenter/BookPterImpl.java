package com.example.mydouban.presenter;

import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.inte.BookInter;
import com.example.mydouban.inte.DataCallBack;
import com.example.mydouban.inte.MovieInter;
import com.example.mydouban.model.BookModelImpl;
import com.example.mydouban.model.FutureMovieModelImpl;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/8 0:53
 */
public class BookPterImpl implements BookInter.BookPterInter {
    private BookInter.BookViewInter<Book> view;
    private BookInter.BookModInter<Book> modle;
    private BookCallBack callBack;

    public BookPterImpl(BookInter.BookViewInter<Book> view,String tag) {
        this.view = view;
        modle = new BookModelImpl(tag);
        callBack=new BookCallBack();
    }


    @Override
    public void initData() {
        view.loaderAnimStar();
        modle.getData(callBack);
    }

    @Override
    public void moreData() {
         modle.moreData(callBack);
    }

    class BookCallBack implements DataCallBack<Book> {

        @Override
        public void dataLose(String message) {
            view.loaderAnimStop();
            view.showDiao();
        }

        @Override
        public void dataSucceed(Book data) {
            view.notifyData(data);
            view.loaderAnimStop();
        }
    }

}
