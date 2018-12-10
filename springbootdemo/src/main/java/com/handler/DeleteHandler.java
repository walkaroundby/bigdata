package com.handler;

public interface DeleteHandler {

    /**
     * xx
     * @return
     * @param appId
     * @throws Exception
     */
    void preDelete(String appId) throws Exception;

    /**
     * xx
     * @param appId
     * @throws Exception
     */
    void doDelete(String appId) throws Exception;

    /**
     * xx
     * @param appId
     * @throws Exception
     */
    void postDelete(String appId) throws Exception;
}
