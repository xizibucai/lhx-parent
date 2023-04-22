package com.lhx.dm.user.vo;

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
public class VideoBaseVo {
    private Integer id;
    private String title;
    private String cover;

}
