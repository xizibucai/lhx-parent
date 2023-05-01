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
public class DanMuQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private String vid;

    private String color;

    private String time;

    private Integer type;

    private String text;


}
