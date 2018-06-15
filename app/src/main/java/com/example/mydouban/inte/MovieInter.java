package com.example.mydouban.inte;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/5 23:23
 */
public interface MovieInter {
    public interface MoviePterInter extends BasePresenterInter   {
        /**
         * 数据获取
         */
        void  initData();

        /**
         * 加载更多数据
         */
        void  moreData();

    }

    public interface MovieModInter<M>   {
        /**
         * 获取M数据
         * @return M数据
         */
        void getData(DataCallBack<M> dataCallBack);
        void moreData(DataCallBack<M> dataCallBack);

}


    public interface MovieViewInter<M> extends ViewInterface {
        void loaderAnimStar() ;
        void loaderAnimStop() ;
        void  notifyData(M data);
        void showDiao();

    }


}
