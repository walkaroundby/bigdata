package com.handler;

import com.alibaba.fastjson.JSONObject;

public interface PutHandler {
    /**
     * xx
     * @param appName
     * @param params
     * @throws Exception
     */
    void prePut(String appName, JSONObject params) throws Exception;

    /**
     * xx
     * @param appName
     * @param params
     * @throws Exception
     */
    JSONObject doPut(String appName, JSONObject params) throws Exception;

    /**
     * xx
     * @param appName
     * @param params
     * @throws Exception
     */
    void postPut(String appName, JSONObject params) throws Exception;
}
