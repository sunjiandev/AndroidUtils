package com.sunkaisens.androidutils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author :yangwenhao
 * 邮箱:yangwenhao@sunkaisens.com
 * 时间:2018/4/9 10:20
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getCanonicalName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(initLayout());
        ButterKnife.bind(this);
        initView();
        initActivity();
    }

    public void initActivity() {
        Activity activity = childInitActivity();
        Log.d(TAG, "init actiivty : " + activity.getClass().getCanonicalName());
    }

    /**
     * 初始化 当前activity
     *
     * @return
     */
    protected abstract Activity childInitActivity();


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 初始化参数
     */
    protected abstract void initView();

    /**
     * 初始化布局
     *
     * @return 布局id
     */

    protected abstract int initLayout();


    /**
     * 跳转到指定Activity
     */
    public void go(Intent intent) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(intent);
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    /**
     * 跳转到指定Activity
     */
    public void go(Class<?> cls) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(this, cls));
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }

    }

    /**
     * 跳转到指定Activity,携带String传值
     */
    public void go(Class<?> cls, String extra) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(this, cls).putExtra(GlobalVar.INTENT_DATA, extra));
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    /**
     * 跳转到指定Activity,携带String传值
     */
    public void go(Class<?> cls, String extraKey, String extraValue) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(this, cls).putExtra(extraKey, extraValue));
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    /**
     * 跳转到指定Activity,携带String传值
     */
    public void go(Class<?> cls, String extraKey1, String extraValue1, String extraKey2, String extraValue2) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {

            startActivity(new Intent(this, cls).putExtra(extraKey1, extraValue1).putExtra(extraKey2, extraValue2));
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    public void go(Class<?> cls, Bundle bundle) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(this, cls).putExtras(bundle));
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    /**
     * 跳转到指定Activity,并且结束当前Activity
     */
    public void goThenKill(Class<?> cls) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(getApplicationContext(), cls));
            finish();
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    public void goThenKill(Class<?> cls, String extraKey, String extraValue) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(getApplicationContext(), cls).putExtra(extraKey, extraValue));
            finish();
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    public void goThenKill(Class<?> cls, String extraKey1, String extraValue1, String extraKey2, String extraValue2) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(getApplicationContext(), cls).putExtra(extraKey1, extraValue1).putExtra(extraKey2, extraValue2));
            finish();
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    public void goForResult(Class<?> cls, int requestCode) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivityForResult(new Intent(getApplicationContext(), cls), requestCode);
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    /**
     * 跳转到指定Activity,并且结束当前Activity,携带String传值
     */
    public void goThenKill(Class<?> cls, String extra) {
        if (GlobalVar.NETWORK_IS_CONNECTED) {
            startActivity(new Intent(getApplicationContext(), cls).putExtra(GlobalVar.INTENT_DATA, extra));
            finish();
        } else {
            ToastUtil.showToast(getString(R.string.net_err));
        }
    }

    /**
     * 控制View显示隐藏
     */
    public void changeView(int viewStatus, int... viewId) {
        if (null == viewId) {
            return;
        }
        for (int id : viewId) {
            findViewById(id).setVisibility(viewStatus);
        }
    }

    public void changeBackgroundColor(String color, int... viewId) {
        if (null == viewId) {
            return;
        }

        for (int id : viewId) {
            findViewById(id).setBackgroundColor(Color.parseColor(color));
        }
    }

    /**
     * View显示状态
     */
    public int getVisibility(int viewId) {
        return findViewById(viewId).getVisibility();
    }

    /**
     * 设置TextView文本
     */
    public void setTextInfo(int viewId, CharSequence text) {

        if (TextUtils.isEmpty(text)) {
            return;
        }
        View view = findViewById(viewId);

        if (view instanceof TextView) {
            ((TextView) view).setText(text);
        } else {
            Log.d(TAG, "setTextInfo ==> view != TextView");
        }
    }


}
