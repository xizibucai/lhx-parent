package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.ImageCollection;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-04-15
 */
public interface ImageCollectionService extends IService<ImageCollection> {

    R imgCollectionGetUserId(String id);

    R delCollection(String galleryID, String id);
}
