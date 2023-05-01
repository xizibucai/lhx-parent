package com.lhx.dm.user.vo.uploadVo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UPImageListVo implements Serializable {
    private Integer id;
    private String url;
    private String name;
    private String description;
    private Date createTime;
    private String createName;
    private Integer status;
    private String imgClass;//分类
}
