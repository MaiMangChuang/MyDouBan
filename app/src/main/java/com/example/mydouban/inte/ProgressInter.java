package com.example.mydouban.inte;

/**
 * 类描述：加载视图与内容视图，错误提示的显示控制
 * 创建人：maimanchuang
 * 创建时间：2018/8/7 15:52
 */
public interface ProgressInter {
    /**
     * 加载界面
     */
    void showLoading();

    /**
     * 错误提示页面
     * @param msg 错误信息
     */
    void  showError(String msg);

    /**
     * 显示正文内容
     */
    void  showValue();

}
