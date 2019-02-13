package com.executor;

import com.annotation.ServiceHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Map;

/**
 * <p>
 * Title: hanlder代理服务
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
 * Create Time: 2015/12/24
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

public class HandlerProxy {
    private static Logger LOG = LoggerFactory.getLogger(HandlerProxy.class);

    /**
     * 查找指定类型的某个功能的hanlder
     * @param handlerClass 功能handler接口类
     * @param type 应用类型
     * @param <T>
     * @return
     */
    public static <T> T  getHandler(Class<T> handlerClass,String type){
        ApplicationContext wac = ApplicationContextProvider.getApplicationContext();
        Map<String,T> maps =  wac.getBeansOfType(handlerClass);
        T t = null;
        for (Map.Entry<String,T> entry : maps.entrySet()){
            T handler = entry.getValue();
            LOG.info("find handler with name:{},class is:{}", entry.getKey(), handler.getClass());

            ServiceHandler serviceHandler = AnnotationUtils.findAnnotation(handler.getClass(), ServiceHandler.class);
        	String handlerType = serviceHandler.value();

        	if(StringUtils.equals(handlerType, type)){
        		LOG.info("get handler for type:{},the class is:{}", type, handler.getClass());
        		t = handler;
        		break;
        	}
        }
        return t;
    }
}
