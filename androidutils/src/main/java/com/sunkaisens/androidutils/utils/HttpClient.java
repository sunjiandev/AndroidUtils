package com.sunkaisens.androidutils.utils;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/28 11:11
 * Description:
 */
public class HttpClient {

    private static final int DEFAULT_TIMEOUT = 30;
    private static String BASE_URI;
    private static HttpClient httpClient;

    private HttpClient() {

    }

    public void setBaseUri(String baseUri) {
        if (!TextUtils.isEmpty(baseUri)) {
            BASE_URI = baseUri;
        }
    }

    public static synchronized HttpClient getHttpClient() {

        if (httpClient == null) {
            return new HttpClient();
        } else {
            return httpClient;
        }
    }

    public static <T> Subscription subscribeDefault(Observable<T> observable,
                                                    Observer<T> subscriber) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();

    }

    public Retrofit getRetrofit() {
        ScalarsConverterFactory scalarsConverterFactory = ScalarsConverterFactory
                .create();
        return new Retrofit.Builder().baseUrl(BASE_URI)
                .addConverterFactory(scalarsConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())// 支持RxJava
                .build();

    }

    /**
     * 创建 OkHttpClient
     */
    public OkHttpClient createOkHttpClient(Interceptor downloadInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        if (downloadInterceptor != null) {
            builder.addNetworkInterceptor(downloadInterceptor);
        }

        return builder.build();
    }
}