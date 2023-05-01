package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Comments;
import com.lhx.dm.user.mapper.CommentsMapper;
import com.lhx.dm.user.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-25
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Override
    public R getComment(String vid, String page, String pageSize) {

        QueryWrapper<Comments> wrapper = new QueryWrapper<>();
        wrapper.eq("vid",vid);
        return null;
    }
}
