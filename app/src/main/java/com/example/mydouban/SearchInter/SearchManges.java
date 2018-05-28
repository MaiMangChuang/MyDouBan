package com.example.mydouban.SearchInter;

import android.util.Log;

import com.example.mydouban.inte.SearchCall;

import java.util.HashMap;

/**
 * 类描述：查询实现类的管理类
 * 创建人：maimanchuang
 * 创建时间：2018/5/24 0:38
 */
public class SearchManges {

    /**
     * 存放查询类的对象
     */
    private static HashMap<String,SearchCall> searchCalls=new HashMap<String,SearchCall>();
    public static String nowSearchCall;

    public static void put(String key,SearchCall searchCall){
        if(searchCalls.get(key)==null){
            Log.e("mmmmmm", "存对象");
            searchCalls.put(key,searchCall);
        }
    }

    /**
     * 获取你所需要的查询对象
     * @param key 你所需要查询对象的类名（请将该类建在“com.example.mydouban.SearchInter”此包下）
     * @return
     */
    public static SearchCall get(String key){
        SearchCall searchCall=null;
        if(searchCalls.get(key)==null){
            Log.e("mmmmmm", "实例对象");
            Class aClass= null;
            try {
                aClass = Class.forName("com.example.mydouban.SearchInter."+key);
                searchCall=(SearchCall) aClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            put(key,searchCall);
        }
        Log.e("mmmmmm", "直接拿");
        nowSearchCall=key;
        return searchCalls.get(key);
    }

    public static HashMap<String, SearchCall> getSearchCalls() {
        return searchCalls;
    }
}
