package me.jeeson.android.mvp.data;

/**
 * Created by 2017/6/12 14:54
 * Contact with smuwjs@163.com
 */

import android.util.SparseArray;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 *  Retrofit Manager
 * Created by Yoosir on 2016/10/24 0024.
 */
public class RetrofitManager {

    private Retrofit mRetrofit;

    /**
     *  类似 Synchronized
     *  http://www.ibm.com/developerworks/cn/java/j-jtp06197.html
     */
    private  OkHttpClient mOkHttpClient;

    private final Map<String, Object> mRetrofitManagerCache = new LinkedHashMap<>();

    private RetrofitManager(OkHttpClient okHttpClient){
        this.mOkHttpClient = okHttpClient;
    }

    /**
     * Create an implementation of the API endpoints defined by the {@code service} interface.
     * @param service 服务接口
     * @return T
     */
    @SuppressWarnings("unchecked") // Single-interface proxy creation guarded by parameter safety.
    public <T> T createService(final Class<T> service){
        return mRetrofit.create(service);
    }
}