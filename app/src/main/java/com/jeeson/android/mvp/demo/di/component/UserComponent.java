package com.jeeson.android.mvp.demo.di.component;



import com.jeeson.android.mvp.demo.app.AppComponent;
import com.jeeson.android.mvp.demo.di.module.UserModule;
import com.jeeson.android.mvp.demo.mvp.ui.activity.UserActivity;
import com.jeeson.android.mvp.di.scope.ActivityScope;

import dagger.Component;


/**
 * Created by jess on 9/4/16 11:17
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
@Component(modules = UserModule.class,dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity activity);
}
