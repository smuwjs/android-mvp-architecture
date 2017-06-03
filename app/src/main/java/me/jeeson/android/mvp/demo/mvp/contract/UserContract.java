package me.jeeson.android.mvp.demo.mvp.contract;

import me.jeeson.android.mvp.arch.base.DefaultAdapter;
import me.jeeson.android.mvp.arch.mvp.IModel;
import me.jeeson.android.mvp.arch.mvp.IView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import io.reactivex.Observable;
import me.jeeson.android.mvp.demo.mvp.model.entity.User;

/**
 * Created by Jeeson 9/4/16 10:47
 * Contact with smuwjs@163.com
 */
public interface UserContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setAdapter(DefaultAdapter adapter);
        void startLoadMore();
        void endLoadMore();
        //申请权限
        RxPermissions getRxPermissions();
    }
    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel{
        Observable<List<User>> getUsers(int lastIdQueried, boolean update);
    }
}
