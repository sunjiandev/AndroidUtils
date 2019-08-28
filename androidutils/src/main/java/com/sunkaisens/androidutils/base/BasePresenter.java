package com.sunkaisens.androidutils.base;

import java.lang.ref.WeakReference;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/27 20:15
 * Description:
 */
public class BasePresenter<T> {

    private WeakReference<T> mViewRef;
    protected BaseActivity activity;

    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    public BasePresenter(BaseActivity activity) {
        this.activity = activity;
    }

    protected T getView() {
        if (mViewRef != null) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    public boolean isViewAttach() {
        return getView() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
