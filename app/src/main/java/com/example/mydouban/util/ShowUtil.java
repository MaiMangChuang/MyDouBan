package com.example.mydouban.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;


/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/2/11 20:25
 */
public final class ShowUtil {
    private Context context;
    private String packageCodePath;
     private    Class mClass;
    public ShowUtil(Context context) {
        this.context = context;
        packageCodePath = context.getPackageCodePath();
    }


    public void showLog(int objects) {
        Log.e(packageCodePath, "showLog: " + objects);
    }

    public void showLog(String objects) {
        Log.e(packageCodePath, "showLog: " + objects);
    }

    public void showLog(boolean objects) {
        Log.e(packageCodePath, "showLog: " + objects);
    }

    public void showLog(float objects) {
        Log.e(packageCodePath, "showLog: " + objects);
    }

    public void showLog(double objects) {
        Log.e(packageCodePath, "showLog: " + objects);
    }
    public void showLog(Object object) {
        Log.e(packageCodePath, "showLog: " + showObject(object));
    }
    public void showLog(List objects) {
        for (Object massge : objects) {
            showTose(massge);
        }
    }

    public void showTose(Object object) {
        Toast.makeText(context, showObject(object), Toast.LENGTH_SHORT).show();
    }

    public void showTose(String objects) {
        Toast.makeText(context, objects, Toast.LENGTH_SHORT).show();
    }

    public void showTose(int objects) {
        Toast.makeText(context, objects, Toast.LENGTH_SHORT).show();
    }

    public void showTose(boolean objects) {
        Toast.makeText(context, objects + "", Toast.LENGTH_SHORT).show();
    }


    public void myStartActivity(Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    public void myStartActivity(Class<?> cls, String key, Parcelable value) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(key, value);
        Intent intent = new Intent(context, cls);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void myStartActivity(Class<?> cls, String key, String value) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(key, value);
        context.startActivity(intent);
    }
    private String showObject(Object object){
        mClass= object.getClass();
        if(mClass==null){
            return "无法获取该类Class对象";
        }
        Field[] field=mClass.getDeclaredFields();
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("\n").append(mClass.getCanonicalName()).append(":\n");
        for(Field f : field) {
            f.setAccessible(true);
            stringBuilder.append(f.getName()).append(":");
            try {
                stringBuilder.append(f.get(object)).append(";\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return "类属性解析出现错误";
            }

        }
        return stringBuilder.toString();
    }


}
