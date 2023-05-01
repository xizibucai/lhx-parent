package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Friend;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-04-18
 */
public interface FriendService extends IService<Friend> {

    /** 获取好友列表
     * @param request*/
    R getFriendList(HttpServletRequest request);

    R getFollowing(HttpServletRequest request, Integer id);

    R getFollowers(HttpServletRequest request, Long page, Long pageSize, Integer id);

    R followCount(String id);

    R followCancel(Integer id, HttpServletRequest request);

    R followStatus(Integer id, HttpServletRequest request);

    R follow(Long id, HttpServletRequest request);
}
