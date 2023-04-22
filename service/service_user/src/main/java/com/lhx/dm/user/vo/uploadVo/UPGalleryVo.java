package com.lhx.dm.user.vo.uploadVo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UPGalleryVo implements Serializable {
    private Integer id;
    private String title;
    private String url;
    private String description;
    private Date createTime;
    private Integer status;
}
