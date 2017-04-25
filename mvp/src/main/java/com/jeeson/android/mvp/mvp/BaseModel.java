package com.jeeson.android.mvp.mvp;

import com.jeeson.android.mvp.integration.IRepositoryManager;

/**
 * Created by jeeson on 8/5/16 12:55
 * contact with smuwjs@163.com
 */
public class BaseModel implements IModel{
    protected IRepositoryManager mRepositoryManager;//用于管理网络请求层,以及数据缓存层

    public BaseModel(IRepositoryManager repositoryManager) {
        this.mRepositoryManager = repositoryManager;
    }

    @Override
    public void onDestroy() {
        if (mRepositoryManager != null) {
            mRepositoryManager = null;
        }
    }
}
