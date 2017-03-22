package com.jeeson.android.mvp.di.module;

import com.jeeson.android.mvp.widget.imageloader.BaseImageLoaderStrategy;
import com.jeeson.android.mvp.widget.imageloader.glide.GlideImageLoaderStrategy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jeeson on 8/5/16 16:10
 * contact with smuwjs@163.com
 */
@Module
public class ImageModule {

    @Singleton
    @Provides
    public BaseImageLoaderStrategy provideImageLoaderStrategy(GlideImageLoaderStrategy glideImageLoaderStrategy) {
        return glideImageLoaderStrategy;
    }

}
