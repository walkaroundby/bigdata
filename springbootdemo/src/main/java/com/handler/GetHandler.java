package com.handler;

import com.alibaba.fastjson.JSONObject;


public interface GetHandler {
    /**
     * xxx
     * @param id
     * @throws Exception
     */
    void preGet(String id) throws Exception;

    /**
     * xx
     * @param id
     * @return
     * @throws Exception
     */
    JSONObject doGet(String id) throws Exception;

    /**
     * xxx
     * @param id
     * @throws Exception
     */
    void postGet(String id) throws Exception;
}
