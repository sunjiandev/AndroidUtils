package com.sunkaisens.androidutils.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sunkaisens.androidutils.SunApp;

import java.util.Set;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/28 9:27
 * Description:
 */
public class SpUtils {

    private static volatile SpUtils mInstance;
    private final SharedPreferences sharedPreferences;

    private SpUtils() {
        Context context = SunApp.getInstance().getContext();
        sharedPreferences = context.getSharedPreferences("config_param", Context.MODE_PRIVATE);

    }

    public static SpUtils getInstance() {
        if (mInstance == null) {
            synchronized (SpUtils.class) {
                if (mInstance == null) {
                    mInstance = new SpUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 保存String 类型的数据
     *
     * @param key   key
     * @param value value
     * @return 操作结果
     */
    public boolean putString(String key, String value) {
        return sharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * 保存int 类型的数据
     *
     * @param key   key
     * @param value value
     * @return 操作结果
     */
    public boolean putInt(String key, int value) {
        return sharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * 保存float 类型的数据
     *
     * @param key   key
     * @param value value
     * @return 操作结果
     */
    public boolean putFloat(String key, float value) {
        return sharedPreferences.edit().putFloat(key, value).commit();
    }

    /**
     * 保存set 类型的数据
     *
     * @param key   key
     * @param value value
     * @return 操作结果
     */
    public boolean putStringSet(String key, Set<String> value) {
        return sharedPreferences.edit().putStringSet(key, value).commit();
    }

    /**
     * 获取String 类型的数据
     *
     * @param key      key
     * @param defValue 默认值
     * @return 操作结果
     */
    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * 获取int 类型的数据
     *
     * @param key      key
     * @param defValue 默认值
     * @return 操作结果
     */
    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    /**
     * 获取float 类型的数据
     *
     * @param key      key
     * @param defValue 默认值
     * @return 操作结果
     */
    public float getFloat(String key, float defValue) {
        return sharedPreferences.getFloat(key, defValue);
    }

    /**
     * 获取set 类型的数据
     *
     * @param key key
     * @return 操作结果
     */
    public Set<String> getSetString(String key) {
        return sharedPreferences.getStringSet(key, null);
    }

    /**
     * 清除数据
     */
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    /**
     * 移除某一个值
     *
     * @param key key
     */
    public void removeData(String key) {
        sharedPreferences.edit().remove(key).apply();
    }
}
