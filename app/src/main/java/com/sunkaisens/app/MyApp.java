package com.sunkaisens.app;

import android.app.Application;

import com.sunkaisens.androidutils.SunApp;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/27 20:39
 * Description:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SunApp.getInstance().init(this);
    }
}
