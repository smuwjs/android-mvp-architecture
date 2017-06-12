package me.jeeson.android.mvp.demo.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.jeeson.android.mvp.arch.base.App;
import me.jeeson.android.mvp.arch.base.BaseHolder;
import me.jeeson.android.mvp.arch.di.component.AppComponent;
import me.jeeson.android.mvp.arch.imageloader.ImageLoader;

import butterknife.BindView;
import io.reactivex.Observable;

import me.jeeson.android.mvp.data.imageloader.glide.GlideImageConfig;
import me.jeeson.android.mvp.demo.R;
import me.jeeson.android.mvp.demo.mvp.model.entity.User;

/**
 * Created by Jeeson 9/4/16 12:56
 * Contact with smuwjs@163.com
 */
public class UserItemHolder extends BaseHolder<User> {

    @BindView(R.id.iv_avatar)
    ImageView mAvater;
    @BindView(R.id.tv_name)
    TextView mName;
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架

    public UserItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到Application的地方,拿到AppComponent,从而得到用Dagger管理的单例对象
        mAppComponent = ((App) itemView.getContext().getApplicationContext()).getAppComponent();
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(User data, int position) {
        Observable.just(data.getLogin())
                .subscribe(s -> mName.setText(s));

        mImageLoader.loadImage(mAppComponent.appManager().getCurrentActivity() == null
                        ? mAppComponent.application() : mAppComponent.appManager().getCurrentActivity(),
                GlideImageConfig
                        .builder()
                        .url(data.getAvatarUrl())
                        .imageView(mAvater)
                        .build());
    }


    @Override
    protected void onRelease() {
        mImageLoader.clear(mAppComponent.application(), GlideImageConfig.builder()
                .imageViews(mAvater)
                .build());
    }
}
