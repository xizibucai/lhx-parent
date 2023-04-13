package com.lhx.dm.user.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 视频集合
 * </p>
 *
 * @author lhx
 * @since 2023-03-19
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VideosSet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 状态（2：完结，1：更新中，-1：停更，0未播放）
     */
    @TableField("states")
    private Long states;

    /**
     * 封面图片
     */
    @TableField("image")
    private String image;

    /**
     * 剧情类型id
     */
    @TableField("videos_class_id")
    private Long videosClassId;

    /**
     * 种类(0:TV、1:剧场版、2:电影)
     */
    @TableField("kind")
    private Long kind;

    /**
     * 首发时间
     */
    @TableField("first_time")
    private Date firstTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 创建人id
     */
    @TableField("create_by")
    private Long createBy;

    /**
     * 修改人id
     */
    @TableField("update_by")
    private Long updateBy;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic
    @TableField("is_deleted")
    private Boolean isDeleted;

    /**
     * 创建人名称
     */
    @TableField("create_name")
    private String createName;

    /**
     * 修改人名称
     */
    @TableField("update_name")
    private String updateName;

    /**
     * 图集状态 0未发布 1已发布
     */
    @TableField("publish_status")
    private Integer publishStatus;
    @TableField("other_title")
    private String otherTitle;

}
