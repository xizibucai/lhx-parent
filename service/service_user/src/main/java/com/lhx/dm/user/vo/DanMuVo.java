package com.lhx.dm.user.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author hc
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DanMuVo implements Serializable {
    private String time;
    private int type;
    private String color;
    // private String content;
    private String text;
}
