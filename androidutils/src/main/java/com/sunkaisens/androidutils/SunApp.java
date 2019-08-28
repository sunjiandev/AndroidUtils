package com.sunkaisens.androidutils;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * @author:sjy
 * @date:2019-07-22
 * @email:sjy_mail@163.com
 * @Description:
 */
public class SunApp {


    private static volatile SunApp mInstance;
    private Context context;

    private SunApp() {
    }

    public static SunApp getInstance() {
        if (mInstance == null) {
            synchronized (SunApp.class) {
                if (mInstance == null) {
                    mInstance = new SunApp();
                }
            }
        }
        return mInstance;
    }

    public Context getContext() {
        if (context == null) {
            throw new RuntimeException("没有调用 SunApp 的 init 函数");
        }
        return context;
    }

    public void init(Context context) {
        this.context = context;
        PrettyFormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder().tag("sjy").methodCount(0).showThreadInfo(true).methodOffset(7).build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
