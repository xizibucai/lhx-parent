package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.VideosClass;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.query.VideoClassQuery;

/**
 * <p>
 * 视频类型 服务类
 * </p>
 *
 * @author lhx
 * @since 2023-03-19
 */
public interface VideosClassService extends IService<VideosClass> {

    R addVideosClass(VideosClass videosClass);

    R videosClassList(Long pageNo, Long pageSize, VideoClassQuery videoClassQuery);

    R videosClassUpdate(VideosClass videosClass);

    R videosClassDelete(Integer id);
}
