package me.jeeson.android.mvp.demo.di.module;

import me.jeeson.android.mvp.arch.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import me.jeeson.android.mvp.demo.mvp.contract.UserContract;
import me.jeeson.android.mvp.demo.mvp.model.UserModel;

/**
 * Created by Jeeson 9/4/16 11:10
 * Contact with smuwjs@163.com
 */
@Module
public class UserModule {
    private UserContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public UserModule(UserContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UserContract.View provideUserView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    UserContract.Model provideUserModel(UserModel model){
        return model;
    }
}
