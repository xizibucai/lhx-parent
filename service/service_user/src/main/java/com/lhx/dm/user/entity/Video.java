package com.lhx.dm.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Video implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 视频名称
     */
    private String name;

    /**
     * 云端视频资源
     */
    private String videoSourceId;

    /**
     * 原始文件名称
     */
    private String videoOriginalName;

    /**
     * 播放次数
     */
    private Long playCount;

    /**
     * 视频时长
     */
    private String duration;

    /**
     * 视频源文件大小（字节）
     */
    private Double size;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 视频集合id
     */
    private Long videsSetId;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private Boolean isDeleted;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 修改人id
     */
    private Long updateBy;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 修改人名称
     */
    private String updateName;

    /**
     * 状态(1:启用，0：禁用，2:审核)
     */
    private Long status;


    /**
     * 封面
     */
    private String image;
    @TableField("intro")
    private String intro;
}
