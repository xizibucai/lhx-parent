package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Commentvideo;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.mapper.CommentvideoMapper;
import com.lhx.dm.user.service.CommentvideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.vo.Comments.CommentsVideoVo;
import com.lhx.dm.user.vo.Comments.Comments_reply;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-05-01
 */
@Service
public class CommentvideoServiceImpl extends ServiceImpl<CommentvideoMapper, Commentvideo> implements CommentvideoService {

    @Override
    public R getcomments(Integer vid, Long pageNo, Long pageSize) {
        ArrayList<CommentsVideoVo> vos = new ArrayList<>();
        QueryWrapper<Commentvideo> wrapper = new QueryWrapper<>();
        wrapper.eq("vid",vid);
        wrapper.eq("parent_id",0);
        Page<Commentvideo> userPage = new Page<>(pageNo, pageSize);
        Page<Commentvideo> page = baseMapper.selectPage(userPage, wrapper);
        List<Commentvideo> records = page.getRecords();

        QueryWrapper<Commentvideo> wrapperitem = new QueryWrapper<>();
        wrapperitem.eq("vid",vid);
        wrapperitem.ne("parent_id",0);
        List<Commentvideo> itemList = list(wrapperitem);
        for (Commentvideo record : records) {
            CommentsVideoVo vo = new CommentsVideoVo();
            vo.setCid(record.getId().toString());
            vo.setCreated_at(record.getCreatedAt());
            vo.setContent(record.getContent());
            vo.setName(record.getName());
            vo.setUid(record.getUid().toString());
            vo.setAvatar(record.getAvatar());
            List<Comments_reply> replyList = new ArrayList<>();
            for (Commentvideo item : itemList) {
                if (item.getParentId().equals(record.getId())) {
                    Comments_reply reply = new Comments_reply();
                    reply.setRid(item.getId().toString());
                    reply.setUid(item.getUid().toString());
                    reply.setCreated_at(item.getCreatedAt());
                    reply.setContent(item.getContent());
                    reply.setName(item.getName());
                    reply.setAvatar(item.getAvatar());
                    reply.setReply_uid(record.getId().toString());
                    reply.setReply_name(record.getName());
                    replyList.add(reply);
                }
            }
            vo.setReply(replyList);
            vos.add(vo);
        }







        return R.ok().data("comments",vos);
    }
}
