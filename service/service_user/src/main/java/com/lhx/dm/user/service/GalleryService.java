package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Gallery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.entity.vo.GalleryVo;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
public interface GalleryService extends IService<Gallery> {


    R galleryAdd(Gallery gallery);

    R galleryList(HttpSession session);

    R galleryDelById(Integer id);

    R galleryUpdate(Gallery gallery);

    R galleryListPage(Long pageNo, Long pageSize, GalleryVo galleryVo);


    R imageListByGalleryId(Integer id);

    R galleryPublish(Integer id);

}
