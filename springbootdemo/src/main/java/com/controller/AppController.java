package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.request.RequestParams;
import com.executor.baseexecutor.BaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author luowei
 * @date 2018-12-03 17:58
 */
@RestController
@RequestMapping(value = "/app")
public class AppController {
    @Autowired
    private BaseExecutor baseExecutor;

    /**
     *
     * @param id
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public JSONObject post(@RequestParam("id") String id,
                           @RequestBody RequestParams request) {
        return baseExecutor.doPost(id, request.getParams(), null);
    }

    /**
     *
     * @param id
     * @param type
     * @param userInfo
     */
    @RequestMapping(value="", method = RequestMethod.DELETE)
    public void delete(@RequestParam("id") String id,
                       @RequestParam("type") String type) {
        baseExecutor.doDelete(id, type, null);
    }

    /**
     *
     * @param id
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.PUT)
    public JSONObject put(@RequestParam("id") String id,
                          @RequestBody RequestParams request) {
        return baseExecutor.doPut(id, request.getParams(), null);
    }

    /**
     *
     * @param id
     * @param type
     * @param userInfo
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public JSONObject get(@RequestParam("id") String id,
                          @RequestParam("type") String type) {
        return baseExecutor.doGet(id, type, null);
    }
}
