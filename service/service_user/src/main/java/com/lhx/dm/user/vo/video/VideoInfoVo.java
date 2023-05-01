package com.lhx.dm.user.vo.video;

import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.entity.Video;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class VideoInfoVo implements Serializable {
    private String vid;
    private String title;
    private String cover;
    private String desc;
    private Boolean copyright;
    private Date created_at;
    private VideoInfoAutherVo author;
    private List<ResourceVo> resource;
    private VideoInteractive interactive;






}
