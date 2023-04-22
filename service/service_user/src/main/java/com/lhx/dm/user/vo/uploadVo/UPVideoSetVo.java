package com.lhx.dm.user.vo.uploadVo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UPVideoSetVo implements Serializable {
    private Integer id;
    private String title;
    private String otherTitle;
    private Long states;
    private String image;
    private Long videosClassId;
    private Long kind;
    private Date firstTime;
    private String createName;
    private String intro;
    private Integer publishStatus;//图集状态 0未发布 1已发布
}
