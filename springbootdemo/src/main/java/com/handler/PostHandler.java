package com.handler;

import com.alibaba.fastjson.JSONObject;

public interface PostHandler {
    /**
     * xx
     * @param appName
     * @param params
     * @throws Exception
     */
    void prePost(String appName, JSONObject params) throws Exception;

    /**
     * xx
     * @param appName
     * @param params
     * @return
     * @throws Exception
     */
    JSONObject doPost(String appName, JSONObject params) throws Exception;

    /**
     * xx
     * @param appName
     * @param params
     * @throws Exception
     */
    void postPost(String appName, JSONObject params) throws Exception;
}
