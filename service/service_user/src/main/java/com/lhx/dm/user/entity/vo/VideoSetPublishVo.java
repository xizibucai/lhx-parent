package com.lhx.dm.user.entity.vo;

import com.lhx.dm.user.entity.Video;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VideoSetPublishVo {
    private Integer id;
    private Date createTime;
    private String url;
    private String createName;
    private String title;
    private Long status;
    private List<Video> videos;
    private String videosClass;
}
