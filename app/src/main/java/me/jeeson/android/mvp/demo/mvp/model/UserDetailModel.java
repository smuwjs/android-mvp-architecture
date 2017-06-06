package me.jeeson.android.mvp.demo.mvp.model;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import me.jeeson.android.mvp.arch.di.scope.FragmentScope;
import me.jeeson.android.mvp.arch.integration.IRepositoryManager;
import me.jeeson.android.mvp.arch.mvp.BaseModel;
import me.jeeson.android.mvp.demo.mvp.contract.UserDetailContract;
import me.jeeson.android.mvp.demo.mvp.model.api.cache.CommonCache;
import me.jeeson.android.mvp.demo.mvp.model.api.service.UserService;
import me.jeeson.android.mvp.demo.mvp.model.entity.UserDetail;

/**
 * @Description: //todo
 * @anthor Jeeson Email:smuwjs@163.com
 * @time 2017/6/6 11:21
 */
@FragmentScope
public class UserDetailModel extends BaseModel implements UserDetailContract.Model {

    @Inject
    public UserDetailModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Observable<UserDetail> getUserDetail(String username, boolean update) {
        Observable<UserDetail> userDetail = mRepositoryManager.obtainRetrofitService(UserService.class)
                .getUserDetail(username);
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return mRepositoryManager.obtainCacheService(CommonCache.class)
                .getUserDetail(userDetail
                        , new DynamicKey(username)
                        , new EvictDynamicKey(update))
                .flatMap(new Function<Reply<UserDetail>, ObservableSource<UserDetail>>() {
                    @Override
                    public ObservableSource<UserDetail> apply(@NonNull Reply<UserDetail> listReply) throws Exception {
                        return Observable.just(listReply.getData());
                    }
                });
    }
}