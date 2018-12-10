package com.executor.baseexecutor;

import com.alibaba.fastjson.JSONObject;
import com.entity.request.UserInfo;
import com.exception.HandlerNotFoundException;
import com.exception.PermissionException;
import com.exception.SdpOperationException;
import com.executor.HandlerProxy;
import com.handler.DeleteHandler;
import com.handler.GetHandler;
import com.handler.PostHandler;
import com.handler.PutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author luowei
 * @date 2018-12-04 16:38
 */
@Component
public class BaseExecutor implements Executor {
    private static Logger LOG = LoggerFactory.getLogger(BaseExecutor.class);

    @Override
    public JSONObject doPost(String appName, JSONObject params, UserInfo userInfo) {
        validateUserInfo(params.getString("type"), PostHandler.class, userInfo);
        PostHandler postHandler = HandlerProxy.getHandler(PostHandler.class, params.getString("type"));
        JSONObject result ;
        if (postHandler == null) {
            throw new HandlerNotFoundException(params.getString("type"), PostHandler.class);
        }
        else {
            // 预创建
            try {
                postHandler.prePost(appName, params);
            } catch (SdpOperationException e) {
                throw e;
            }catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 创建
            try {
                result = postHandler.doPost(appName, params);
            } catch (SdpOperationException e) {
                throw e;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 创建后
            try {
                postHandler.postPost(appName, params);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }
        }
        return result;
    }

    @Override
    public void doDelete(String appId, String type, UserInfo userInfo) {
        validateUserInfo(type, DeleteHandler.class, userInfo);

        DeleteHandler deleteHandler = HandlerProxy.getHandler(DeleteHandler.class, type);
        if (deleteHandler == null) {
            throw new HandlerNotFoundException(type, DeleteHandler.class);
        }
        else {
            // 预删除
            try {
                deleteHandler.preDelete(appId);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 删除
            try {
                deleteHandler.doDelete(appId);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 删除后
            try {
                deleteHandler.postDelete(appId);
            } catch (SdpOperationException e) {
                throw e;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }
        }
    }

    @Override
    public JSONObject doPut(String appName, JSONObject params, UserInfo userInfo)  {
        validateUserInfo(params.getString("type"), PutHandler.class, userInfo);

        PutHandler puHandler = HandlerProxy.getHandler(PutHandler.class, params.getString("type"));
        JSONObject result ;
        if (puHandler == null) {
            throw new HandlerNotFoundException(params.getString("type"), PutHandler.class);
        }
        else {
            // 预创建
            try {
                puHandler.prePut(appName, params);
            } catch (SdpOperationException e) {
                throw e;
            }catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 创建
            try {
                result = puHandler.doPut(appName, params);
            } catch (SdpOperationException e) {
                throw e;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 创建后
            try {
                puHandler.postPut(appName, params);
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }
        }
        return result;
    }

    @Override
    public JSONObject doGet(String appId, String type, UserInfo userInfo) {
        validateUserInfo(type, DeleteHandler.class, userInfo);

        GetHandler getHandler = HandlerProxy.getHandler(GetHandler.class, type);
        JSONObject result;
        if (getHandler == null) {
            throw new HandlerNotFoundException(type, GetHandler.class);
        }
        else {
            // 预获取
            try {
                getHandler.preGet(appId);
            } catch (SdpOperationException e) {
                throw e;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 获取
            try {
                result = getHandler.doGet(appId);
            } catch (SdpOperationException e) {
                throw e;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }

            // 获取后
            try {
                getHandler.postGet(appId);
            } catch (SdpOperationException e) {
                throw e;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new SdpOperationException(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * 校验权限
     * @param userInfo
     */
    private void validateUserInfo(String type, Class handler, UserInfo userInfo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        userInfo = (UserInfo) authentication.getPrincipal();

        if(userInfo.getUserId()!= "262337"){
            throw new PermissionException(type, handler);
        }
    }
}
