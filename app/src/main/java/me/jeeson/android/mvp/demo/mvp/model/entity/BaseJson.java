package me.jeeson.android.mvp.demo.mvp.model.entity;

import java.io.Serializable;

import me.jeeson.android.mvp.demo.mvp.model.api.Api;

/**
 * 如果你服务器返回的数据固定为这种方式(字段名可根据服务器更改)
 * 替换范型即可重用BaseJson
 * Created by Jeeson 26/09/2016 15:19
 * Contact with smuwjs@163.com
 */

public class BaseJson<T> implements Serializable{
    private T data;
    private String code;
    private String msg;

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 请求是否成功
     * @return
     */
    public boolean isSuccess() {
        if (code.equals(Api.RequestSuccess)) {
            return true;
        } else {
            return false;
        }
    }
}
