package com.executor.baseexecutor;

import com.alibaba.fastjson.JSONObject;
import com.entity.request.UserInfo;

/**
 * @author luowei
 * @date 2018-12-04 16:34
 */
public interface Executor {

    /**
     * 增
     * @param appName
     * @param params
     * @param userInfo
     * @return
     */
    JSONObject doPost(String appName, JSONObject params, UserInfo userInfo);

    /**
     * 删
     * @param appName
     * @param userInfo
     * @param type
     * @return
     */
    void doDelete(String appName, String type, UserInfo userInfo);

    /**
     * 改
     * @param appName
     * @param params
     * @param userInfo
     * @return
     */
    JSONObject doPut(String appName, JSONObject params, UserInfo userInfo);

    /**
     * 获取
     * @param id
     * @param userInfo
     * @param type
     * @return
     */
    JSONObject doGet(String id, String type, UserInfo userInfo);
}
