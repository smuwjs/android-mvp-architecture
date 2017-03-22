package com.jeeson.android.mvp.di.component;


import com.jeeson.android.mvp.base.BaseApplication;
import com.jeeson.android.mvp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jeeson on 14/12/2016 13:58
 * Contact with smuwjs@163.com
 */
@Singleton
@Component(modules={AppModule.class})
public interface BaseComponent {
    void inject(BaseApplication application);
}
