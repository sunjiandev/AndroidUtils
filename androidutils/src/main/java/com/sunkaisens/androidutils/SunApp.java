package com.sunkaisens.androidutils;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
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
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(3)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("sjy")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
