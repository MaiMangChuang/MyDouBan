package com.example.mydouban.inte;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/7 9:34
 */
public interface BookInter {

    public interface BookPterInter {
        /**
         * 数据获取
         */
        void  initData();

        /**
         * 加载更多数据
         */
        void  moreData();

    }

    public interface BookModInter<M>   {
        /**
         * 获取M数据
         *
         */
        void getData(DataCallBack<M> dataCallBack);
        void moreData(DataCallBack<M> dataCallBack);

    }


    public interface BookViewInter<M>  extends ViewInterface {
        void loaderAnimStar() ;
        void loaderAnimStop() ;
        void  notifyData(M data);
        void showDiao();

    }
}
