package com.lhx.dm.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author lhx
 * @since 2023-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 头像
     */
    @TableField(value = "face_img",fill = FieldFill.INSERT)
    private String faceImg;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 账号（手机号）
     */
    @TableField("account")
    private String account;

    /**
     * 性别(0-女 1-男 2-保密)
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 状态（1-启用，0-禁用）
     */
    @TableField("status")
    private Integer status;

    /**
     * 等级 2会员 1游客
     */
    @TableField("grade")
    private Integer grade;

    /**
     * 用户简介
     */
    @TableField("intro")
    private String intro;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic
    @TableField("is_deleted")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
