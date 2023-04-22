package com.lhx.dm.user.vo.uservo;

import lombok.Data;

import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UserInfoVo {
    private Integer id;
    private String userName;
    private String faceImg;
    private String password;
    private String account;
    private Integer sex;
    private Integer status;
    private String intro;
    private Date createTime;
}
