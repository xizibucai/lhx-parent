package com.lhx.dm.user.vo.MessageVo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Data
public class UserMessagesVo implements Serializable {
    private String avatar;
    private String name;
    private List<UserMessagesItemVo> messages = new ArrayList<>();
}
