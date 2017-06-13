package me.jeeson.android.mvp.data.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import okhttp3.HttpUrl;
import retrofit2.http.Url;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @anthor Jeeson Email:smuwjs@163.com
 * @time 2017/6/12 15:11
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface ServiceHost {

    String value() default "";
}
