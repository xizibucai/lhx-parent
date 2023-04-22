package com.lhx.dm.user.vo.MessageVo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UserMessagesItemVo implements Serializable {
    private String fid;
    private String from_id;
    private String content;
    private Date created_at;

}
