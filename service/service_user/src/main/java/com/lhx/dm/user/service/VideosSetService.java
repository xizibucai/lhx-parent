package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.VideosSet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.entity.query.VideoSetFrontQuery;
import com.lhx.dm.user.entity.query.VideoSumQuery;

/**
 * <p>
 * 视频集合 服务类
 * </p>
 *
 * @author lhx
 * @since 2023-03-19
 */
public interface VideosSetService extends IService<VideosSet> {

    R videosSetAdd(VideosSet videosSet);

    R videosSetDelete(Integer id);

    R videosSetUpdate(VideosSet videosSet);

    R videosSetList();

    R videosSetListPage(Long pageNo, Long pageSize, VideoSumQuery videosSet);


    R videoSetPublish(Long id);

    R videoSetPublishList(Long id);

    R videoSetBaseList();


    R videoSetGetFrontList(Long pageNo, Long pageSize, VideoSetFrontQuery videoSetFrontQuery);


}
