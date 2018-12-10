package com.component;

import com.annotation.SdpServiceHandler;
import com.constant.HandlerType;
import com.executor.baseexecutor.BaseExecutor;

/**
 * Created by clj on 2017/3/1.
 * Description:
 */
@SdpServiceHandler(value = HandlerType.APP_GROUP)
public class AppGroups extends BaseExecutor {
}
