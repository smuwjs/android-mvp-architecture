package me.jeeson.android.mvp.demo.mvp.contract;

import com.chad.library.adapter.base.BaseQuickAdapter;

import io.reactivex.Observable;
import me.jeeson.android.mvp.arch.mvp.IModel;
import me.jeeson.android.mvp.arch.mvp.IView;
import me.jeeson.android.mvp.demo.mvp.model.entity.UserDetail;

/**
 * @Description: //todo
 * @anthor Jeeson Email:smuwjs@163.com
 * @time 2017/6/6 11:23
 */
public interface UserDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setAdapter(BaseQuickAdapter adapter);

        void refresh();
    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<UserDetail> getUserDetail(String username, boolean update);
    }
}