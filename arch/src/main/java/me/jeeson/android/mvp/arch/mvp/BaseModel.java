package me.jeeson.android.mvp.arch.mvp;

import me.jeeson.android.mvp.arch.integration.IRepositoryManager;

/**
 * Created by Jeeson 8/5/16 12:55
 * contact with smuwjs@163.com
 */
public class BaseModel implements IModel {
    protected IRepositoryManager mRepositoryManager;//用于管理网络请求层,以及数据缓存层

    public BaseModel(IRepositoryManager repositoryManager) {
        this.mRepositoryManager = repositoryManager;
    }

    @Override
    public void onDestroy() {
        mRepositoryManager = null;
    }
}
