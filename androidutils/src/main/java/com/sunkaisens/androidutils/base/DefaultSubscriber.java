package com.sunkaisens.androidutils.base;

import android.util.Log;

import rx.Subscriber;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/29 17:24
 * Description:
 */
public abstract class DefaultSubscriber<T> extends Subscriber<T> {
    private final String TAG = DefaultSubscriber.class.getSimpleName();

    @Override
    public void onCompleted() {
        if (!isUnsubscribed()) {
            unsubscribe();
        }
    }

    @Override
    public void onError(final Throwable e) {
        Log.e(TAG, e.getMessage());
        onCompleted();

    }

}