package com.jeeson.android.mvp.rxerrorhandler.core;

import android.content.Context;

import com.jeeson.android.mvp.rxerrorhandler.handler.ErrorHandlerFactory;
import com.jeeson.android.mvp.rxerrorhandler.handler.listener.ResponseErroListener;

import static com.jeeson.android.mvp.rxerrorhandler.utils.Preconditions.checkNotNull;

/**
 * Created by jeeson on 9/2/16 13:27
 * Contact with smuwjs@163.com
 */
public class RxErrorHandler {
    public final String TAG = this.getClass().getSimpleName();
    private ErrorHandlerFactory mHandlerFactory;

    private RxErrorHandler(Builder builder) {
        this.mHandlerFactory = builder.errorHandlerFactory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ErrorHandlerFactory getmHandlerFactory() {
        return mHandlerFactory;
    }

    public static final class Builder {
        private Context context;
        private ResponseErroListener responseErroListener;
        private ErrorHandlerFactory errorHandlerFactory;

        private Builder() {
        }

        public Builder with(Context context) {
            this.context = context;
            return this;
        }

        public Builder responseErroListener(ResponseErroListener responseErroListener) {
            this.responseErroListener = responseErroListener;
            return this;
        }

        public RxErrorHandler build() {
            checkNotNull(context,"context is required");
            checkNotNull(responseErroListener,"responseErroListener is required");


            this.errorHandlerFactory = new ErrorHandlerFactory(context, responseErroListener);

            return new RxErrorHandler(this);
        }
    }


}
