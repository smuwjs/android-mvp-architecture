package com.jeeson.android.mvp.rxerrorhandler.handler;

import com.jeeson.android.mvp.rxerrorhandler.core.RxErrorHandler;
import rx.Subscriber;

/**
 * Created by jeeson on 9/2/16 14:41
 * Contact with smuwjs@163.com
 */

public abstract class ErrorHandleSubscriber<T> extends Subscriber<T> {
    private ErrorHandlerFactory mHandlerFactory;

    public ErrorHandleSubscriber(RxErrorHandler rxErrorHandler){
        this.mHandlerFactory = rxErrorHandler.getmHandlerFactory();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        mHandlerFactory.handleError(e);
    }

}

