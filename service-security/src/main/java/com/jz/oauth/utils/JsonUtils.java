package com.jz.oauth.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jayszxs (jayszxs7@gmail.com)
 * @date 2019/3/14
 */
public class JsonUtils {

    public static String deserializer(Object object) {
        return JSONObject.toJSONString(object);
    }

    public static <T> T serializable(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, clazz);
    }
}
