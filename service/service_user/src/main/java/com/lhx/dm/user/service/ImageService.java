package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Image;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.query.ImageQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
public interface ImageService extends IService<Image> {

    //新增图片
    R imageAdd(Image image);

    //更新图片
    R imageUpdate(Image image);

    //删除图片
    R imageDel(Integer id);
    //图片列表
    R imageList();

    R imageListPage(Long pageNo, Long pageSize, ImageQuery imageQuery);

    R imageGetById(Integer id);

    R updateStatus(List<String> ids, Integer status);
}
