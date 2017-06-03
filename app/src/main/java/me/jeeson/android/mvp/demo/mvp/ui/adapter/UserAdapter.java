package me.jeeson.android.mvp.demo.mvp.ui.adapter;

import android.view.View;

import me.jeeson.android.mvp.arch.base.BaseHolder;
import me.jeeson.android.mvp.arch.base.DefaultAdapter;

import java.util.List;

import me.jeeson.android.mvp.demo.R;
import me.jeeson.android.mvp.demo.mvp.model.entity.User;
import me.jeeson.android.mvp.demo.mvp.ui.holder.UserItemHolder;

/**
 * Created by Jeeson 9/4/16 12:57
 * Contact with smuwjs@163.com
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
