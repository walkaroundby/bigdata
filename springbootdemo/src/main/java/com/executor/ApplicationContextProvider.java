package com.executor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: Module Information
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

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextProvider.applicationContext = applicationContext;
    }
    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


}
