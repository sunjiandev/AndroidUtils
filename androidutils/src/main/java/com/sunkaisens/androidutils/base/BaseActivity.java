package com.sunkaisens.androidutils.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/27 20:20
 * Description:
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());

        presenter = createPresenter();
        initView();

        if (presenter!=null){
            presenter.attachView((V) this);
        }
    }

    protected abstract void initView();

    protected abstract T createPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
