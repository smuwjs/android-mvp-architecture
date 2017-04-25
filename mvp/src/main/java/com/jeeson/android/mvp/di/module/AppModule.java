package com.jeeson.android.mvp.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.jeeson.android.mvp.integration.IRepositoryManager;
import com.jeeson.android.mvp.integration.RepositoryManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jeeson on 8/4/16.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    public Gson provideGson(){return new Gson();}

    @Singleton
    @Provides
    public IRepositoryManager provideRepositoryManager(RepositoryManager repositoryManager) {
        return repositoryManager;
    }

}
