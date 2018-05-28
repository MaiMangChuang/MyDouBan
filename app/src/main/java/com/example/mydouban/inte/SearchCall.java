package com.example.mydouban.inte;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * 类描述：搜索的接口
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 23:01
 */
public interface SearchCall {
    /**
     * 查询方法
     * @param value 查询的内容
     */
    void searchCall(String value, BaseQuickAdapter adapter);
}
