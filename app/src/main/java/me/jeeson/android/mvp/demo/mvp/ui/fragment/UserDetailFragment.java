package me.jeeson.android.mvp.demo.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;


import butterknife.BindView;
import me.jeeson.android.mvp.arch.base.BaseFragment;
import me.jeeson.android.mvp.arch.di.component.AppComponent;
import me.jeeson.android.mvp.arch.utils.UiUtils;
import me.jeeson.android.mvp.demo.R;
import me.jeeson.android.mvp.demo.di.component.DaggerUserDetailComponent;
import me.jeeson.android.mvp.demo.di.module.UserDetailModule;
import me.jeeson.android.mvp.demo.mvp.contract.UserDetailContract;
import me.jeeson.android.mvp.demo.mvp.presenter.UserDetailPresenter;

import static me.jeeson.android.mvp.core.util.Preconditions.checkNotNull;


/**
 * Created by Jeeson on 2017/5/19.
 * MVP UserDetailFragment
 */

public class UserDetailFragment extends BaseFragment<UserDetailPresenter> implements UserDetailContract.View {

    @BindView(R.id.recycler_user_detail)
    RecyclerView mRecyclerUserDetail;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    private String mUsername;

    public static UserDetailFragment newInstance() {
        return new UserDetailFragment();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerUserDetailComponent
                .builder()
                .appComponent(appComponent)
                .userDetailModule(new UserDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_detail, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.requestUserDetail(mUsername, false);
    }


    @Override
    public void setData(Object data) {
        mUsername = (String) data;
    }


    @Override
    public void showLoading() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void setAdapter(BaseQuickAdapter adapter) {
        UiUtils.configRecycleView(mRecyclerUserDetail, new LinearLayoutManager(getContext()));
        mRecyclerUserDetail.setAdapter(adapter);
    }

    @Override
    public void refresh() {
        mPresenter.requestUserDetail(mUsername, true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mUsername = null;
    }
}