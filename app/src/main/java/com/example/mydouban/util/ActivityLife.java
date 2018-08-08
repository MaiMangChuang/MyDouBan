package com.example.mydouban.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/1/7 16:49
 */
public final class ActivityLife {
    private static List<Activity> activityList;
    private static ActivityLife activityLife;

    private ActivityLife() {
    }

    public static ActivityLife getActivityLife() {
        if (activityLife == null) {
            activityLife = new ActivityLife();
        }
        return activityLife;
    }

    public static List<Activity> getActivityList() {
        if (activityList == null) {
            activityList = new ArrayList<>();
        }
        return activityList;
    }
}
