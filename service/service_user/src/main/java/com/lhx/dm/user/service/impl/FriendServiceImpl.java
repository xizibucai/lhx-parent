package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Friend;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.vo.MessageVo.FriendListVo;
import com.lhx.dm.user.mapper.FriendMapper;
import com.lhx.dm.user.service.FriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.service.UserService;
import com.lhx.dm.user.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

    @Autowired
    private UserService userService;

    @Override
    public R getFriendList(HttpServletRequest request) {
        String userId = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Friend> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",userId);
        List<Friend> friendList = list(wrapper);
        ArrayList<String> fid = new ArrayList<>();
        //获取好友id列表
        for (Friend friend : friendList) {
            fid.add(friend.getFid().toString());
        }
        QueryWrapper<User> userwrapper = new QueryWrapper<>();
        List<User> friends = userService.listByIds(fid);
        ArrayList<FriendListVo> vos = new ArrayList<>();
        //获取好友详细信息
        for (User friend : friends) {
            FriendListVo vo = new FriendListVo();
            vo.setId(friend.getId().toString());
            vo.setUid(friend.getId().toString());
            vo.setName(friend.getUserName());
            vo.setStatus(friend.getStatus().toString());
            vo.setCreated_at(friend.getCreateTime());
            vo.setAvatar(friend.getFaceImg());
            vos.add(vo);
        }
        return R.ok().data("messages",vos);
    }
}
