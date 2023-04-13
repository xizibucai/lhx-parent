package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;

import com.lhx.dm.user.entity.Gallery;
import com.lhx.dm.user.entity.Image;
import com.lhx.dm.user.entity.query.ImageQuery;
import com.lhx.dm.user.mapper.ImageMapper;
import com.lhx.dm.user.oss.service.ImageOssService;
import com.lhx.dm.user.service.ImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    @Autowired
    private ImageOssService imageOssService;

    @Override
    public R imageAdd(Image image) {
        boolean save = save(image);
        return save ? R.ok() : R.error();
    }

    @Override
    public R imageUpdate(Image image) {
        Integer id = image.getId();
        Image byId = getById(id);
        if (!byId.getUrl().equals(image.getUrl())) {
            imageOssService.ossImageDel(Long.valueOf(image.getId()));
        }
        updateById(image);
       return R.ok();
    }

    @Override
    public R imageDel(Integer id) {
        boolean isSuccess = this.removeById(id);

        return isSuccess ? R.ok() : R.ok();
    }

    @Override
    public R imageList() {
        List<Image> imageList = this.list();
        return R.ok().data("imageList",imageList);
    }

    @Override
    public R imageListPage(Long pageNo, Long pageSize, ImageQuery imageQuery) {
        String begin = imageQuery.getBegin();
        String end = imageQuery.getEnd();
        String createName = imageQuery.getCreateName();
        String name = imageQuery.getName();
        List valueList = imageQuery.getValueList();
        Integer status = imageQuery.getStatus();
        String imgClassId = imageQuery.getImgClassId();

        QueryWrapper<Image> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(imgClassId)){
            queryWrapper.eq("img_class_id",imgClassId);
        }
        if (!StringUtils.isEmpty(status)){
            queryWrapper.eq("status",status);
        }
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(createName)) {
            queryWrapper.like("create_name",createName);
        }
        if (!valueList.isEmpty()) {
            queryWrapper.in("img_class_id",valueList);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("create_time", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("update_time", end);
        }
        Page<Image> page = new Page<>(pageNo, pageSize);
        baseMapper.selectPage(page,queryWrapper);
        long total = page.getTotal();
        List<Image> records = page.getRecords();
        return R.ok().data("total",total).data("list",records);
    }

    @Override
    public R imageGetById(Integer id) {
        Image image = getById(id);
   return R.ok().data("image",image);
    }

    @Override
    public R updateStatus(List<String> ids, Integer status) {
        List<Image> images = this.listByIds(ids);
        for (Image image : images) {
            image.setStatus(status);
        }
        updateBatchById(images);
        return R.ok();
    }


}
