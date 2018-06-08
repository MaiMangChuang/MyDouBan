package com.example.mydouban.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mydouban.R;


/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/3/18 16:27
 */
public class GlideUtil {
    private static RequestOptions options = new RequestOptions()
            .error(R.mipmap.lost);
 public  static void showGlide(Context context, String url, ImageView view){
         Glide.with(context).load(url).apply(options).thumbnail(0.1f).into(view);
    }
}
