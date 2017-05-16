package me.jeeson.android.mvp.demo.di.component;



import me.jeeson.android.mvp.demo.di.module.UserModule;
import me.jeeson.android.mvp.demo.mvp.ui.activity.UserActivity;
import me.jeeson.android.mvp.di.component.AppComponent;
import me.jeeson.android.mvp.di.scope.ActivityScope;

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
