package com.example.mydouban.inte;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/6/5 23:48
 */
public interface DataCallBack<T>{
    /**
     *  失败时的回调方法
     * @param message 失败信息
     */
    void dataLose(String message);

    /**
     *  成功时的回调方法
     * @param data 数据内容
     */
    void dataSucceed(T data);
}
