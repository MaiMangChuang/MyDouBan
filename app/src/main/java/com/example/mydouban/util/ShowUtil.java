package com.example.mydouban.util;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/2/11 20:25
 */
public class ShowUtil {
    private Activity activity;
    public ShowUtil(Activity activity){
        this.activity=activity;
    }

    public void showLog(String objects) {
        Log.e(activity.getLocalClassName(), "showLog: " + objects);
    }
    public void showLog(boolean objects) {
        Log.e(activity.getLocalClassName(), "showLog: " + objects);
    }
    public void showLog(float objects) {
        Log.e(activity.getLocalClassName(), "showLog: " + objects);
    }
    public void showLog(double objects) {
        Log.e(activity.getLocalClassName(), "showLog: " + objects);
    }
    public void showLog(List objects) {
        for(Object massge : objects){
            showTose(massge.toString());
        }
    }

    public void showTose(Objects objects) {
        Toast.makeText(activity, objects.toString(), Toast.LENGTH_SHORT).show();
    }

    public void showTose(String objects) {
        Toast.makeText(activity, objects, Toast.LENGTH_SHORT).show();
    }
    public void showTose(int objects) {
        Toast.makeText(activity, objects, Toast.LENGTH_SHORT).show();
    }
    public void showTose(boolean objects) {
        Toast.makeText(activity, objects+"", Toast.LENGTH_SHORT).show();
    }
}
