package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Likes;
import com.lhx.dm.user.mapper.LikeMapper;
import com.lhx.dm.user.service.LikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.utils.JwtUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-25
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Likes> implements LikeService {

    @Override
    public R add(Integer dmId, HttpServletRequest request, String type) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        Likes like = new Likes();
        like.setDmId(dmId);
        like.setUserId(Integer.valueOf(uid));
        like.setType(type);
        like.setIsDeleted(false);
        boolean save = save(like);
        return save ?R.ok():R.error().message("点赞失败");
    }

    @Override
    public R cancel(Integer dmId, HttpServletRequest request, String type) {
        String uid = JwtUtils.getMemberIdByJwtToken(request);
        QueryWrapper<Likes> wrapper = new QueryWrapper<>();
        wrapper.eq("dm_id",dmId);
        wrapper.eq("user_id",uid);
        wrapper.eq("type",type);
        boolean remove = remove(wrapper);
        return remove ?R.ok():R.error().message("取消点赞失败");
    }

    @Override
    public Boolean getStatus(Integer dmId, String uid, String type) {
        QueryWrapper<Likes> wrapper = new QueryWrapper<>();
        wrapper.eq("dm_id",dmId);
        wrapper.eq("user_id",Integer.valueOf(uid));
        wrapper.eq("type",type);
        Likes one = getOne(wrapper);
        return one != null;
    }
}
