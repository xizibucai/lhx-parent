package com.lhx.dm.user.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author hc
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ImageQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String imgClassId;

    private String provenance;

    private String createName;

    private Integer status;

    private ArrayList valueList = new ArrayList();

    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    private String end;
}
