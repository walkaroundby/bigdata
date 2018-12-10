package com.exception;

import com.alibaba.fastjson.JSONObject;
import com.constant.ErrorLevelType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Title: 门户操作执行错误
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
 * Create Time: 2015/12/23
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

public class SdpOperationException extends RuntimeException{
	private static final long serialVersionUID = 305046405015532836L;
	
	private static Logger LOG = LoggerFactory.getLogger(SdpOperationException.class);
	
	JSONObject object;
	String level;
	
    public SdpOperationException() {
    	super();
    }

    public SdpOperationException(String message) {
        this(message, ErrorLevelType.ERROR.getAlias());
    }
    
    public SdpOperationException(String message, Throwable cause) {
        this(message, ErrorLevelType.ERROR.getAlias(), null, cause);
    }
    
    public SdpOperationException(String message, String level) {
    	this(message, level, null);
    }
    
    public SdpOperationException(String message, String level, JSONObject object) {
    	super(message);
    	
    	// 如果异常类型为error则记录日志
    	if(level.equals(ErrorLevelType.ERROR)) {
    		LOG.error(message);
    	}
    	
        this.object = object;
        this.level = level;
    }

    public SdpOperationException(String message, String level, JSONObject object,  Throwable cause) {
        super(message, cause);

        // 如果异常类型为error则记录日志
        if(level.equals(ErrorLevelType.ERROR)) {
        	LOG.error(message, cause);
        }
        
        this.object = object;
        this.level = level;
        
    }

	public JSONObject getObject() {
		return object;
	}

	public void setObject(JSONObject object) {
		this.object = object;
	}

	public String getLevel() {
		return level;
	}
}
