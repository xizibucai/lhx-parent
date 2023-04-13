package com.lhx.dm.user.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GalleryPublishVo {
    private Integer id;
    private Date createTime;
    private String url;
    private String createName;
    private String title;
    private String className;
    private Integer imageSum;



}
