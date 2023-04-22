package com.lhx.dm.user.vo.uservo;


import com.lhx.dm.user.entity.Video;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UserUploadVideoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;//影集id
    private String title; //影集标题
    private String image;////影集封面
    private String username;//上传人名称
    private String status;//影集状态
    private Date firstTime;//影集首发时间
    private String videoClass;//影集类型
    private String describe;//描述

    // private String itemId;//视频
    // private String itemName;//视频名称
    // private String itemImage;//视频封面
    // private String payCount;//视频播放次数
    // private String itemDescribe;//视频描述

    private List<Video> videos = new ArrayList<>();
}
