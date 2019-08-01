package com.sunkaisens.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sunkaisens.androidutils.BaseActivity;
import com.sunkaisens.androidutils.TimerUtil;

public class MainActivity extends BaseActivity {


    @Override
    protected Activity childInitActivity() {
        return null;
    }

    @Override
    protected void initView() {

        TimerUtil.getInstance().startTimer(new Runnable() {
            @Override
            public void run() {

                System.out.println("timer = " + true);

            }
        },1000,1000);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
}
