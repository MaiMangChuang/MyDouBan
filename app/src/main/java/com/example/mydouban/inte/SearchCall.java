package com.example.mydouban.inte;

/**
 * 类描述：搜索的接口
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 23:01
 */
public interface SearchCall<T> {
    /**
     * 查询方法
     * @param value 查询的内容
     */
    T searchCall(String value);
}
