package com.jeeson.android.mvp.utils;

import com.jeeson.android.mvp.base.BaseActivity;
import com.jeeson.android.mvp.base.BaseFragment;
import com.jeeson.android.mvp.mvp.BaseView;
import com.trello.rxlifecycle.LifecycleTransformer;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by jeeson on 11/10/2016 16:39
 * Contact with smuwjs@163.com
 */

public class RxUtils {

    public static <T> Observable.Transformer<T, T> applySchedulers(final BaseView view) {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {//显示进度条
                                view.showLoading();
                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doAfterTerminate(new Action0() {
                            @Override
                            public void call() {
                                view.hideLoading();//隐藏进度条
                            }
                        }).compose(RxUtils.<T>bindToLifecycle(view));
            }
        };
    }


    public static <T> LifecycleTransformer<T> bindToLifecycle(BaseView view) {
        if (view instanceof BaseActivity) {
            return ((BaseActivity) view).<T>bindToLifecycle();
        } else if (view instanceof BaseFragment) {
            return ((BaseFragment) view).<T>bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't activity or fragment");
        }

    }

}
