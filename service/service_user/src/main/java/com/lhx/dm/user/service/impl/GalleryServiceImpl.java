package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Gallery;
import com.lhx.dm.user.entity.Image;
import com.lhx.dm.user.entity.vo.GalleryPublishVo;
import com.lhx.dm.user.entity.vo.GalleryVo;
import com.lhx.dm.user.mapper.GalleryMapper;
import com.lhx.dm.user.service.GalleryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.service.ImageService;
import com.lhx.dm.user.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
@Log4j2
@Service
public class GalleryServiceImpl extends ServiceImpl<GalleryMapper, Gallery> implements GalleryService {

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;


    @Override
    public R galleryAdd(Gallery gallery) {
        boolean isSuccess = save(gallery);
        Integer id = gallery.getId();
        log.info("id",id);
        return isSuccess ? R.ok().data("id",id):R.error();
    }

    @Override
    public R galleryList(HttpSession session) {
        Object user = session.getAttribute("user");
        System.out.println("session");
        List<Gallery> galleryList = list();

        return R.ok().data("galleryList",galleryList);
    }

    @Override
    public R galleryDelById(Integer id) {
        boolean isDel = removeById(id);
        return isDel ? R.ok():R.error();
    }

    @Override
    public R galleryUpdate(Gallery gallery) {
        boolean isUpdate = updateById(gallery);
        return isUpdate ? R.ok().data("id",gallery.getId()):R.error();
    }

    @Override
    public R galleryListPage(Long pageNo, Long pageSize, GalleryVo galleryVo) {
        String begin = galleryVo.getBegin();
        String end = galleryVo.getEnd();
        String title = galleryVo.getTitle();
        String userName = galleryVo.getUserName();
        QueryWrapper<Gallery> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title",title);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("create_time", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("update_time", end);
        }
        Page<Gallery> page = new Page<>(pageNo, pageSize);
        baseMapper.selectPage(page,queryWrapper);
        long total = page.getTotal();
        List<Gallery> records = page.getRecords();
        return R.ok().data("total",total).data("list",records);
    }

    @Override
    public R imageListByGalleryId(Integer id) {
        QueryWrapper<Image> wrapperImage = new QueryWrapper<>();
        wrapperImage.eq("gallery_id",id);
        List<Image> list = imageService.list(wrapperImage);
        return R.ok().data("list",list);
    }

    @Override
    public R galleryPublish(Integer id) {
        GalleryPublishVo vo = new GalleryPublishVo();
        Gallery gallery = getById(id);
        vo.setId(id);
        vo.setTitle(gallery.getTitle());
        vo.setUrl(gallery.getUrl());
        vo.setCreateTime(gallery.getCreateTime());
        Integer userId = gallery.getUserId();
        String userName = userService.getById(userId).getUserName();
        vo.setCreateName(userName);

        QueryWrapper<Image> wrapperImage = new QueryWrapper<>();
        wrapperImage.eq("gallery_id",id);
        List<Image> imageList = imageService.list(wrapperImage);
        vo.setImageSum(imageList.size());
        return R.ok().data("vo",vo);
    }
}
