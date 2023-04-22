package com.lhx.dm.user.vo.MessageVo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class FriendListVo implements Serializable {

    private String id;
    private String uid;
    private Date created_at;
    private String name;
    private String avatar;
    private String status;

}
