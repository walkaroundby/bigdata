package com.entity.request;

import lombok.Data;
import java.io.Serializable;

/**
 * @author luowei
 * @date 2018-12-04 17:09
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 7891245963510413200L;
    private String userId;
    private String userName;
}
