package com.example.mydouban.SearchInter;

import android.util.Log;

import com.example.mydouban.bean.SubjectsBean;
import com.example.mydouban.inte.SearchCall;

/**
 * 类描述：电影查询实现类
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 23:58
 */
public class MovieSearch implements SearchCall<SubjectsBean> {
    @Override
    public SubjectsBean searchCall(String value) {
        Log.e("MovieSearch", "电影搜索");
        return null;
    }
}
