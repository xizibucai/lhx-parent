package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Commentvideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-05-01
 */
public interface CommentvideoService extends IService<Commentvideo> {

    R getcomments(Integer vid, Long pageNo, Long pageSize);

}
