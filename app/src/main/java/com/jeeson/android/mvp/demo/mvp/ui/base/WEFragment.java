package com.jeeson.android.mvp.demo.mvp.ui.base;


import com.jeeson.android.mvp.base.BaseFragment;
import com.jeeson.android.mvp.demo.app.App;
import com.jeeson.android.mvp.demo.di.component.AppComponent;
import com.jeeson.android.mvp.mvp.Presenter;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by jess on 8/5/16 14:11
 * contact with jess.yan.effort@gmail.com
 */
public abstract class WEFragment<P extends Presenter> extends BaseFragment<P> {
    protected App mWeApplication;
    @Override
    protected void ComponentInject() {
        mWeApplication = (App)mActivity.getApplication();
        setupFragmentComponent(mWeApplication.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupFragmentComponent(AppComponent appComponent);

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher watcher = App.getRefWatcher(getActivity());//使用leakCanary检测fragment的内存泄漏
        if (watcher != null) {
            watcher.watch(this);
        }
        this.mWeApplication =null;
    }
}
