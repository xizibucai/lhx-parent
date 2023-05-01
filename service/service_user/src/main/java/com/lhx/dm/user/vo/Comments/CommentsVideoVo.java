package com.lhx.dm.user.vo.Comments;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class CommentsVideoVo {
    private  String cid;
    private Date created_at;
    private  String content;
    private  String uid;
    private  String name;
    private  String avatar;
    private List<Comments_reply> reply;
}
