package com.entity.request;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class RequestParams {

    private String type;

    private JSONObject params;

}
