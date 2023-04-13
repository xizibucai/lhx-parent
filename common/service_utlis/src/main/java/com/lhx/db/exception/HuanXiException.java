package com.lhx.db.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hc
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuanXiException extends RuntimeException{
    private Integer code;//状态码

    private String msg;//异常信息
}
