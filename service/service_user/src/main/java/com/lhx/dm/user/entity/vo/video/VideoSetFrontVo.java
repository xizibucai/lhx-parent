package com.lhx.dm.user.entity.vo.video;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VideoSetFrontVo {
    /**主键*/
    private Integer id;

    /**标题*/
    private String title;

    /**其他语言别名名称*/
    private String otherTitle;

    /** 状态（2：完结，1：更新中，-1：停更，0未播放）*/
    private Long states;

    /**封面图片*/
    private String image;

    /**剧情类型*/
    private String videoSetClass;

    /** 种类(0:TV、1:剧场版、2:电影)*/
    private Long kind;

    /**首发时间*/
    private Integer firstTime;

    /**创建人名称*/
    private String createName;
    /**图集内视频图片*/
    private List<String> videoListImage = new ArrayList<>();


}
