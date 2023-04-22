package com.lhx.dm.user.query;

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
public class VideoSumQuery {
    private static final long serialVersionUID = 1L;
    private String title;
    private Integer states;
    private Integer kind;
    private Integer videosClassId;
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    private String end;
}
