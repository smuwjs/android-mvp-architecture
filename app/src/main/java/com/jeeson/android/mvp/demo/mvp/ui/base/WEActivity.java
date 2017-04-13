package com.jeeson.android.mvp.demo.mvp.ui.base;


import com.jeeson.android.mvp.base.BaseActivity;
import com.jeeson.android.mvp.demo.app.App;
import com.jeeson.android.mvp.demo.di.component.AppComponent;
import com.jeeson.android.mvp.mvp.Presenter;

/**
 * Created by jess on 8/5/16 13:13
 * contact with jess.yan.effort@gmail.com
 */
public abstract class WEActivity<P extends Presenter> extends BaseActivity<P> {
    protected App mWeApplication;
    @Override
    protected void ComponentInject() {
        mWeApplication = (App) getApplication();
        setupActivityComponent(mWeApplication.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupActivityComponent(AppComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mWeApplication = null;
    }
}
