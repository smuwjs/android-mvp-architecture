package me.jeeson.android.mvp.demo.di.component;



import dagger.Component;
import me.jeeson.android.mvp.arch.di.component.AppComponent;
import me.jeeson.android.mvp.arch.di.scope.FragmentScope;
import me.jeeson.android.mvp.demo.di.module.UserDetailModule;
import me.jeeson.android.mvp.demo.mvp.ui.fragment.UserDetailFragment;


/**
 * Created by Jeeson on 2017/5/19.
 * Dagger UserDetailComponent
 */

@FragmentScope
@Component(modules = UserDetailModule.class, dependencies = AppComponent.class)
public interface UserDetailComponent {
    void inject(UserDetailFragment fragment);
}