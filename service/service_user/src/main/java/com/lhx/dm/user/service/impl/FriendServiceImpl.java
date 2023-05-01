package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import java.util.stream.Collectors;

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

    @Override
    public R getFollowing(HttpServletRequest request, Integer id) {
        // String id = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Friend> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",id);
        List<Friend> list = list(wrapper);
        List<Long> Fid = list.stream().map(Friend::getFid).collect(Collectors.toList());
        List<User> users = userService.listByIds(Fid);
        return R.ok().data("users",users);
    }

    @Override
    public R getFollowers(HttpServletRequest request, Long pageNo, Long pageSize, Integer id) {
        // String id = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Friend> wrapper = new QueryWrapper<>();
        Page<Friend> userPage = new Page<>(pageNo, pageSize);
        wrapper.eq("fid",id);
        baseMapper.selectPage(userPage, wrapper);
        List<Friend> list = userPage.getRecords();
        long total = userPage.getTotal();
        List<Long> Uid = list.stream().map(Friend::getUid).collect(Collectors.toList());
        List<User> users = userService.listByIds(Uid);
        return R.ok().data("users",users).data("total",total);
    }

    @Override
    public R followCount(String id) {
        QueryWrapper<Friend> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",id);
        int following = list(wrapper).size();
        QueryWrapper<Friend> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("fid",id);
        int followers = list(wrapper1).size();
        return R.ok().data("followers",followers).data("following",following);
    }

    @Override
    public R followCancel(Integer fid, HttpServletRequest request) {
        String Uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Friend> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",Uid);
        wrapper.eq("fid",fid);
        boolean isSuccess = remove(wrapper);
        return isSuccess ? R.ok().data("isSuccess", true) : R.error().data("isSuccess", false);
    }

    @Override
    public R followStatus(Integer fid, HttpServletRequest request) {
        String Uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Friend> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",Uid);
        wrapper.eq("fid",fid);
        Friend one = getOne(wrapper);
        if (one!=null){
            return R.ok().data("follow",true);
        }
        return R.ok().data("follow",false);

    }

    @Override
    public R follow(Long fid, HttpServletRequest request) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        Friend friend = new Friend();
        friend.setFid(fid);
        friend.setUid(Long.valueOf(uid));
        friend.setIsDeleted(false);
        boolean save = save(friend);
        return save?R.ok():R.error().message("关注失败");
    }
}
