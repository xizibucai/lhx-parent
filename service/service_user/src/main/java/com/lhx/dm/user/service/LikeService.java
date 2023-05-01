package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Likes;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-04-25
 */
public interface LikeService extends IService<Likes> {

    R add(Integer dmId, HttpServletRequest request, String type);

    R cancel(Integer dmId, HttpServletRequest request, String type);

    Boolean getStatus(Integer dmId, String uid, String type);
}
