package com.constant;

/**
 * 枚举错误类型
 * @Description
 * @compay ND Co., Ltd
 * @author 吴玉龙
 * @date 2016年2月18日
 */
public enum ErrorLevelType {
	ERROR(1,"ERROR"),
	WARN(2,"WARN"),
	INFO(3,"INFO"),
	DEBUG(4,"DEBUG"),
	ALL(5,"ALL");

    private int code;

    private String alias;

    private ErrorLevelType(final int code, final String alias) {
        this.code = code;
        this.alias = alias;
    }

    public int value() {
        return code;
    }

    public int getCode() {
        return code;
    }

    public String getAlias() {
        return alias;
    }
}
