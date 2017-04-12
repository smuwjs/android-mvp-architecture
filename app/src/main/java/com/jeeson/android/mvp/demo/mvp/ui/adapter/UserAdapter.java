package com.jeeson.android.mvp.demo.mvp.ui.adapter;

import android.view.View;

import com.jeeson.android.mvp.base.BaseHolder;
import com.jeeson.android.mvp.base.DefaultAdapter;
import com.jeeson.android.mvp.demo.R;
import com.jeeson.android.mvp.demo.mvp.model.entity.User;
import com.jeeson.android.mvp.demo.mvp.ui.holder.UserItemHolder;

import java.util.List;

/**
 * Created by jess on 9/4/16 12:57
 * Contact with jess.yan.effort@gmail.com
 */
public class UserAdapter extends DefaultAdapter<User> {
    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<User> getHolder(View v, int viewType) {
        return new UserItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list;
    }
}
