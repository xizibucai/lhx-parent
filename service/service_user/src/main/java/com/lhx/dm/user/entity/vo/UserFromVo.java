package com.lhx.dm.user.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserFromVo implements Serializable {
    private Integer id;
    private String userName;
    private String account;
    private Integer status;
    private Integer grade;
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    private String end;
}
