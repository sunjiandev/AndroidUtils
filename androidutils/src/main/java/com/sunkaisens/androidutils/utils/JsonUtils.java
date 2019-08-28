package com.sunkaisens.androidutils.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/28 10:17
 * Description:json 处理的工具类
 */
public class JsonUtils<T> {


    private static volatile JsonUtils mInstance;

    private JsonUtils() {
    }

    public static JsonUtils getInstance() {
        if (mInstance == null) {
            synchronized (JsonUtils.class) {
                if (mInstance == null) {
                    mInstance = new JsonUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * json 转换 bean
     * @param json json 数据
     * @param cls 类型
     * @param <T> 返回的bean
     * @return
     */
    public <T> T jsonStrToBean(String json, Class<T> cls) throws Exception {
        return JSON.parseObject(json, cls);
    }

    /**
     * bean to json
     * @param bean bean
     * @return 返回的json 数据
     */
    public String beanToJson(T bean) throws Exception {
        return JSON.toJSONString(bean);
    }

    public String getStringValue(String json, String key) throws Exception {
        JSONObject jsonObject = JSON.parseObject(json);
        return jsonObject.getString(key);
    }

    public int getIntValue(String json, String key) throws Exception{
        return JSON.parseObject(json).getInteger(key);
    }

    public boolean getBooleanValue(String json, String key) throws Exception {
        return JSON.parseObject(json).getBoolean(key);
    }

}
