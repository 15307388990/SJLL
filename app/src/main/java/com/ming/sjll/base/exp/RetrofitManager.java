package com.ming.sjll.base.exp;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ming.sjll.api.BasicParamsInterceptor;
import com.ming.sjll.api.Constant;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Retrofit管理类
 *
 */
public class RetrofitManager {
    private static final RetrofitManager retrofitManager = new RetrofitManager();
    private Retrofit retrofit;
    /**
     * 请求超时时间（秒）
     */
    private static final long DEFAULT_TIMEOUT = 30;

    private RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(Constant.BASE_API)
                .addConverterFactory(ResponseConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitManager get() {
        return retrofitManager;
    }




    /**
     * 获取OkHttpClient
     *
     * @return OkHttpClient
     */
    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addNetworkInterceptor(new StethoInterceptor());
        builder.addNetworkInterceptor(
                new BasicParamsInterceptor.Builder()
                        //-----------------------------添加头部-----------------------
                        //.addHeaderParam(ReqHeader.Key.HTTP_PHONETYPE, "android")
                        //-----------------------------添加固定参数-----------------------
                        .addParam("api_type","")
                        .addParam("api_version","4.5.0")
                        .build());
        //builder.addInterceptor(new LogInterceptor());
        builder.retryOnConnectionFailure(false)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return builder.build();
    }

    /**
     * 创建接口服务
     *
     * @param service 接口
     * @param <T>     T
     * @return T
     */
    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
