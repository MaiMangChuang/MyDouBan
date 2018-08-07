package com.example.mydouban.inte;

/**
 * 类描述：
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
