package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.VideosCollection;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-04-16
 */
public interface VideosCollectionService extends IService<VideosCollection> {

    R getVideoSetCollection(String id);

    R delVideoCollection(Integer id, String userID);

    Boolean getVideoStatus(String id, String userID);

    R addVideoCollection(Integer id, String userID);
}
