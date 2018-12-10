package com.exception;

/**
 * <p>
 * Title: 找不到处理类错误
 * </p>
 * <p>
 * Description: Function Description
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: ND Co., Ltd.
 * </p>
 * <p>
 * Create Time: 2015/12/21
 * </p>
 *
 * @author YangYang
 *         <p>
 *         Update Time:
 *         </p>
 *         <p>
 *         Updater:
 *         </p>
 *         <p>
 *         Update Comments:
 *         </p>
 */

public class HandlerNotFoundException extends RuntimeException{
    private String type;
    private Class handler;

    public HandlerNotFoundException(String type, Class handler) {
        super("注册中找不到类型为" + type + "的"+ handler + "处理实现");
        this.type = type;
        this.handler = handler;
    }
}
