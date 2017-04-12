package com.jeeson.android.mvp.demo.mvp.ui.holder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jeeson.android.mvp.base.BaseHolder;
import com.jeeson.android.mvp.demo.R;
import com.jeeson.android.mvp.demo.app.App;
import com.jeeson.android.mvp.demo.mvp.model.entity.User;
import com.jeeson.android.mvp.widget.imageloader.ImageLoader;
import com.jeeson.android.mvp.widget.imageloader.glide.GlideImageConfig;

import butterknife.BindView;
import rx.Observable;

/**
 * Created by jess on 9/4/16 12:56
 * Contact with jess.yan.effort@gmail.com
 */
public class UserItemHolder extends BaseHolder<User> {

    @Nullable
    @BindView(R.id.iv_avatar)
    ImageView mAvater;
    @Nullable
    @BindView(R.id.tv_name)
    TextView mName;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    private final App mApplication;

    public UserItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到Application的地方,拿到AppComponent,从而得到用Dagger管理的单例对象
        mApplication = (App) itemView.getContext().getApplicationContext();
        mImageLoader = mApplication.getAppComponent().imageLoader();
    }

    @Override
    public void setData(User data, int position) {
        Observable.just(data.getLogin())
                .subscribe(RxTextView.text(mName));

        mImageLoader.loadImage(mApplication, GlideImageConfig
                .builder()
                .url(data.getAvatarUrl())
                .imageView(mAvater)
                .build());
    }


    @Override
    protected void onRelease() {
        mImageLoader.clear(mApplication,GlideImageConfig.builder()
                .imageViews(mAvater)
                .build());
    }
}
