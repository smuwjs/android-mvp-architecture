package me.jeeson.android.mvp.demo.mvp.model;

import me.jeeson.android.mvp.arch.di.scope.ActivityScope;
import me.jeeson.android.mvp.arch.integration.IRepositoryManager;
import me.jeeson.android.mvp.arch.mvp.BaseModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import me.jeeson.android.mvp.demo.mvp.contract.UserContract;
import me.jeeson.android.mvp.demo.mvp.model.api.cache.CommonCache;
import me.jeeson.android.mvp.demo.mvp.model.api.service.UserService;
import me.jeeson.android.mvp.demo.mvp.model.entity.User;

/**
 * Created by Jeeson 9/4/16 10:56
 * Contact with smuwjs@163.com
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
        Observable<List<User>> users = mRepositoryManager.obtainRetrofitService(UserService.class)
                .getUsers(lastIdQueried, USERS_PER_PAGE);
        //使用rxcache缓存,上拉刷新则不读取缓存,加载更多读取缓存
        return mRepositoryManager.obtainCacheService(CommonCache.class)
                .getUsers(users
                        , new DynamicKey(lastIdQueried)
                        , new EvictDynamicKey(update))
                .flatMap(new Function<Reply<List<User>>, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(@NonNull Reply<List<User>> listReply) throws Exception {
                        return Observable.just(listReply.getData());
                    }
                });
    }

}
