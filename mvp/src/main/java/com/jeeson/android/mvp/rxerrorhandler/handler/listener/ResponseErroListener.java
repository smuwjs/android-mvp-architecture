package com.jeeson.android.mvp.rxerrorhandler.handler.listener;

import android.content.Context;

/**
 * Created by jeeson on 9/2/16 13:58
 * Contact with smuwjs@163.com
 */
public interface ResponseErroListener {
    void handleResponseError(Context context, Exception e);

    ResponseErroListener EMPTY = new ResponseErroListener() {
        @Override
        public void handleResponseError(Context context, Exception e) {

        }
    };
}
