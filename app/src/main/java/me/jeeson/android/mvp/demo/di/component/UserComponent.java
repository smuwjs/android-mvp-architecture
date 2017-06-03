package me.jeeson.android.mvp.demo.di.component;

import me.jeeson.android.mvp.arch.di.component.AppComponent;
import me.jeeson.android.mvp.arch.di.scope.ActivityScope;

import dagger.Component;
import me.jeeson.android.mvp.demo.di.module.UserModule;
import me.jeeson.android.mvp.demo.mvp.ui.activity.UserActivity;

/**
 * Created by Jeeson 9/4/16 11:17
 * Contact with smuwjs@163.com
 */
@ActivityScope
@Component(modules = UserModule.class,dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity activity);
}
