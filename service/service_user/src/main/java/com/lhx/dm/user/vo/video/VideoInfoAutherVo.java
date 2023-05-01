package com.lhx.dm.user.vo.video;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class VideoInfoAutherVo implements Serializable {
    private String uid;
    private String name;
    private String sign;
    private String avatar;
    private String email;
    private Integer gender;
    private Integer role;
    private String birthday;

}
