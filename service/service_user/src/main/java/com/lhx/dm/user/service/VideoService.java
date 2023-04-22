package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.query.VideoQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-04-01
 */
public interface VideoService extends IService<Video> {

    R videoGetList();

    R videoGetListPage(Long pageNo, Long pageSize, VideoQuery videoQuery);

    R videoLittle();

    R videoFrontGetById(Integer id);
}
