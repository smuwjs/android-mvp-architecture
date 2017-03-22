package com.jeeson.android.mvp.mvp;

import android.content.Intent;

/**
 * Created by jeeson on 16/4/22.
 */
public interface BaseView {

    /**
     * 显示加载
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示信息
     */
    void showMessage(String message);

    /**
     * 跳转activity
     */
    void launchActivity(Intent intent);
    /**
     * 杀死自己
     */
    void killMyself();
}
