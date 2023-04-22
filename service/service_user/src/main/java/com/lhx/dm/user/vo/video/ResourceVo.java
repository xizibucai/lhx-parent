package com.lhx.dm.user.vo.video;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author hc
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResourceVo {
    private String id;
    private String title;
    private String res360;
    private String res480;
    private String res720;
    private String res1080;
    private String original;//原始分辨率视频链接
}
