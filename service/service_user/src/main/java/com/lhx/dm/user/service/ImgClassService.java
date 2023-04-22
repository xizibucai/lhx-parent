package com.lhx.dm.user.service;

import com.lhx.db.result.R;
import com.lhx.dm.user.entity.ImgClass;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.vo.ImageClassVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
public interface ImgClassService extends IService<ImgClass> {

    //查询分类
    R getImgClass();

    //添加类别
    R addImgClass(ImgClass imgClass);

    //删除图片类别
    R deleteImgClass(Integer id);
    //修改图片类别
    R updateImgClass(ImgClass imgClass);

    R getAllImageForPage(Long pageNo, Long pageSize, ImageClassVo imageClassVo);
}
