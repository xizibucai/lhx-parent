package com.lhx.dm.user.vo.Comments;

import com.lhx.dm.user.entity.Comments;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class CommentsVo implements Serializable {

    private Integer id;
    private String content;
    private Date created_at;
    private Integer uid;
    private String name;
    private String avatar;
    private List<Comments> reply=  new ArrayList<>();
    private Integer reply_uid;
    private String reply_name;

}
