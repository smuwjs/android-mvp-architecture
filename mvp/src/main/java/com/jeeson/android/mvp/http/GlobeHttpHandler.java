package com.jeeson.android.mvp.http;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jeeson on 8/30/16 17:47
 * Contact with smuwjs@163.com
 */
public interface GlobeHttpHandler {
    Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response);

    Request onHttpRequestBefore(Interceptor.Chain chain, Request request);

    GlobeHttpHandler EMPTY = new GlobeHttpHandler() {
        @Override
        public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
            //不管是否处理,都必须将response返回出去
            return response;
        }

        @Override
        public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
            //不管是否处理,都必须将request返回出去
            return request;
        }
    };

}
