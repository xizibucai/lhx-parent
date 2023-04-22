package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.UserMessages;
import com.lhx.dm.user.vo.MessageVo.UserMessagesItemVo;
import com.lhx.dm.user.vo.MessageVo.UserMessagesVo;
import com.lhx.dm.user.mapper.UserMessagesMapper;
import com.lhx.dm.user.service.UserMessagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.utils.JwtUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-18
 */
@Service
public class UserMessagesServiceImpl extends ServiceImpl<UserMessagesMapper, UserMessages> implements UserMessagesService {

    @Override
    public R details(HttpServletRequest request, String fid) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<UserMessages> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",uid);
        wrapper.eq("fid",fid);
        List<UserMessages> list = list(wrapper);
        UserMessagesVo vo = new UserMessagesVo();
        vo.setName("戏子不才");
        vo.setAvatar("");
        ArrayList<UserMessagesItemVo> messages = new ArrayList<>();

        for (UserMessages item : list) {
            UserMessagesItemVo userMessagesItemVo = new UserMessagesItemVo();
            userMessagesItemVo.setFid(item.getFid().toString());
            userMessagesItemVo.setFrom_id(item.getFromId().toString());
            userMessagesItemVo.setCreated_at(item.getCreatedAt());
            userMessagesItemVo.setContent(item.getContent());
            messages.add(userMessagesItemVo);
        }
        vo.setMessages(messages);
        System.out.println("messages"+messages);
        return R.ok().data("messages",messages).data("name","123").data("avatar","http://lanhuanxi.oss-cn-hangzhou.aliyuncs.com/2022-12-03/fd626ec7a3684938aef925024f6431c0%E5%B0%8F%E5%9B%9B%EF%BC%884%EF%BC%89.jpg");
    }
}
