package com.jeeson.android.mvp.demo.mvp.model;


import com.jeeson.android.mvp.demo.mvp.contract.UserContract;
import com.jeeson.android.mvp.demo.mvp.model.api.cache.CommonCache;
import com.jeeson.android.mvp.demo.mvp.model.api.service.UserAPIService;
import com.jeeson.android.mvp.demo.mvp.model.entity.User;
import com.jeeson.android.mvp.di.scope.ActivityScope;
import com.jeeson.android.mvp.integration.IRepositoryManager;
import com.jeeson.android.mvp.mvp.BaseModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;


/**
 * Created by jess on 9/4/16 10:56
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
public class UserModel extends BaseModel implements UserContract.Model {
    public static final int USERS_PER_PAGE = 10;

    @Inject
    public UserModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<User>> getUsers(int lastIdQueried, boolean update) {
        Observable<List<User>> users = mRepositoryManager.obtainRetrofitService(UserAPIService.class)
                .getUsers(lastIdQueried, USERS_PER_PAGE);
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return mRepositoryManager.obtainCacheService(CommonCache.class)
                .getUsers(users
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update))
                .flatMap(new Function<Reply<List<User>>, Observable<List<User>>>() {
                    @Override
                    public Observable<List<User>> apply(Reply<List<User>> listReply) {
                        return Observable.just(listReply.getData());
                    }
                });
    }

}
