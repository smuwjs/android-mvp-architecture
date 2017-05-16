package me.jeeson.android.mvp.imageloader;

import android.content.Context;

/**
 * Created by jeeson on 8/5/16 15:50
 * contact with smuwjs@163.com
 */
public interface BaseImageLoaderStrategy<T extends ImageConfig> {
    void loadImage(Context ctx, T config);
    void clear(Context ctx, T config);
}
