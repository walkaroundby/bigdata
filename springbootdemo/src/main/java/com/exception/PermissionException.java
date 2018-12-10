package com.exception;

/**
 * @author luowei
 * @date 2018-12-04 17:23
 */
public class PermissionException extends RuntimeException{
    private String type;
    private Class handler;

    public PermissionException(String type, Class handler) {
        super("权限不足");
        this.type = type;
        this.handler = handler;
    }
}
