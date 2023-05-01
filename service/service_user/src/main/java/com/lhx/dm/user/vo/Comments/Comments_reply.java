package com.lhx.dm.user.vo.Comments;

import lombok.Data;

import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class Comments_reply {
    private String rid;
    private String uid;
    private Date created_at;
    private String content;
    private String name;
    private String avatar;
    private String reply_uid;
    private String reply_name;

}
