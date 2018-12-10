package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.request.RequestParams;
import com.entity.request.UserInfo;
import com.executor.baseexecutor.BaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
                           @RequestBody RequestParams request,
                           @AuthenticationPrincipal UserInfo userInfo) {
        return baseExecutor.doPost(id, request.getParams(), userInfo);
    }

    /**
     *
     * @param id
     * @param type
     * @param userInfo
     */
    @RequestMapping(value="", method = RequestMethod.DELETE)
    public void delete(@RequestParam("id") String id,
                       @RequestParam("type") String type,
                       @AuthenticationPrincipal UserInfo userInfo) {
        baseExecutor.doDelete(id, type, userInfo);
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
                          @RequestBody RequestParams request,
                          @AuthenticationPrincipal UserInfo userInfo) {
        return baseExecutor.doPut(id, request.getParams(), userInfo);
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
                          @RequestParam("type") String type,
                          @AuthenticationPrincipal UserInfo userInfo) {
        return baseExecutor.doGet(id, type, userInfo);
    }
}
