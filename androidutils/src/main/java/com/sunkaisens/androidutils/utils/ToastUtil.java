package com.sunkaisens.androidutils.utils;

import android.widget.Toast;

import com.sunkaisens.androidutils.SunApp;

/**
 * @author:sjy
 * @date:2019-07-22
 * @email:sjy_mail@163.com
 * @Description:
 */
public class ToastUtil {

    private static Toast toast;
    public static void showToast(String tips) {
        if (toast == null) {
            toast = Toast.makeText(SunApp.getInstance().getContext(), tips, Toast.LENGTH_SHORT);
        } else {
            toast.setText(tips);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
