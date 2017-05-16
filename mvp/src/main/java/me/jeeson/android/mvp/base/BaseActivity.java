package me.jeeson.android.mvp.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


import me.jeeson.android.mvp.base.delegate.IActivity;
import me.jeeson.android.mvp.mvp.IPresenter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import javax.inject.Inject;

import static me.jeeson.android.mvp.base.delegate.ActivityDelegate.LAYOUT_FRAME_LAYOUT;
import static me.jeeson.android.mvp.base.delegate.ActivityDelegate.LAYOUT_LINEAR_LAYOUT;
import static me.jeeson.android.mvp.base.delegate.ActivityDelegate.LAYOUT_RELATIVE_LAYOUT;

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity implements IActivity {
    protected final String TAG = this.getClass().getSimpleName();
    @Inject
    protected P mPresenter;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAME_LAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        }
        if (name.equals(LAYOUT_LINEAR_LAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        }
        if (name.equals(LAYOUT_RELATIVE_LAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }
        return view == null ? super.onCreateView(name, context, attrs) : view;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
    }

    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    @Override
    public boolean useEventBus() {
        return true;
    }

    /**
     * 这个Activity是否会使用Fragment,框架会根据这个属性判断是否注册{@link android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks}
     * 如果返回false,那意味着这个Activity不需要绑定Fragment,那你再在这个Activity中绑定继承于 {@link BaseFragment} 的Fragment将不起任何作用
     * @return
     */
    @Override
    public boolean useFragment() {
        return true;
    }

}
