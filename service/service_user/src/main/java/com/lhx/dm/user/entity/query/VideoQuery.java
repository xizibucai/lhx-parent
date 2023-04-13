package com.lhx.dm.user.entity.query;

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
public class VideoQuery {

    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    private String end;
}
