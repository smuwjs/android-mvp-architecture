package com.jeeson.android.mvp.demo.di.component;

import android.app.Application;

import com.google.gson.Gson;
import com.jeeson.android.mvp.base.AppManager;
import com.jeeson.android.mvp.demo.di.module.CacheModule;
import com.jeeson.android.mvp.demo.di.module.ServiceModule;
import com.jeeson.android.mvp.demo.mvp.model.api.cache.CacheManager;
import com.jeeson.android.mvp.demo.mvp.model.api.service.ServiceManager;
import com.jeeson.android.mvp.di.module.AppModule;
import com.jeeson.android.mvp.di.module.ClientModule;
import com.jeeson.android.mvp.di.module.GlobeConfigModule;
import com.jeeson.android.mvp.di.module.ImageModule;
import com.jeeson.android.mvp.rxerrorhandler.core.RxErrorHandler;
import com.jeeson.android.mvp.widget.imageloader.ImageLoader;


import javax.inject.Singleton;

import dagger.Component;

import okhttp3.OkHttpClient;

/**
 * Created by jess on 8/4/16.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, ServiceModule.class, ImageModule.class,
        CacheModule.class, GlobeConfigModule.class})
public interface AppComponent {
    Application Application();

    //服务管理器,retrofitApi
    ServiceManager serviceManager();

    //缓存管理器
    CacheManager cacheManager();

    //Rxjava错误处理管理类
    RxErrorHandler rxErrorHandler();


    OkHttpClient okHttpClient();

    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoader();

    //gson
    Gson gson();

    //用于管理所有activity
    AppManager appManager();
}
