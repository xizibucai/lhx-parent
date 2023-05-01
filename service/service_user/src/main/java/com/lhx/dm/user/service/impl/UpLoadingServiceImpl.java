package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Gallery;
import com.lhx.dm.user.entity.Image;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.entity.VideosSet;
import com.lhx.dm.user.mapper.UserMapper;
import com.lhx.dm.user.service.*;
import com.lhx.dm.user.vo.uploadVo.UPGalleryVo;
import com.lhx.dm.user.vo.uploadVo.UPImageListVo;
import com.lhx.dm.user.vo.uploadVo.UPVideoSetVo;
import com.lhx.dm.user.vo.uploadVo.UserUploadingVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hc
 * @version 1.0
 */
@Service
public class UpLoadingServiceImpl extends ServiceImpl<UserMapper,User> implements UpLoadingService {
    @Autowired
    private UserService userService;
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private VideosSetService videosSetService;

    @Override
    public R userGetGallery(String id) {
        Integer integer = new Integer(id);
        QueryWrapper<Gallery> galleryWrapper = new QueryWrapper<>();
        galleryWrapper.eq("user_id", integer);
        List<Gallery> galleries = galleryService.list(galleryWrapper);
        QueryWrapper<Image> imageWrapper = new QueryWrapper<>();
        imageWrapper.eq("create_by", integer);
        List<Image> images = imageService.list(imageWrapper);
        QueryWrapper<VideosSet> videosSetWrapper = new QueryWrapper<>();
        videosSetWrapper.eq("create_by",integer);
        List<VideosSet> videosSets = videosSetService.list(videosSetWrapper);
        UserUploadingVo vo = SetUpLoadingVo(galleries, images, videosSets);
        int sum = galleries.size() + images.size() + videosSets.size();
        return R.ok().data("vo",vo).data("sum",sum);
    }
    public UserUploadingVo SetUpLoadingVo(List<Gallery> galleries, List<Image> images, List<VideosSet> videosSets){
        UserUploadingVo vo = new UserUploadingVo();
        //图片
        List<UPImageListVo> imageList = images.stream().map(item -> {
            UPImageListVo image = new UPImageListVo();
            BeanUtils.copyProperties(item, image);
            return image;
        }).collect(Collectors.toList());
        vo.setImages(imageList);
        //图集
        List<UPGalleryVo> galleryVos = galleries.stream().map(g -> {
            UPGalleryVo galleryVo = new UPGalleryVo();
            BeanUtils.copyProperties(g, galleryVo);
            return galleryVo;
        }).collect(Collectors.toList());
        vo.setGalleries(galleryVos);
        //影集
        List<UPVideoSetVo> UPVideoSetVo = videosSets.stream().map(g -> {
            UPVideoSetVo VideoList = new UPVideoSetVo();
            BeanUtils.copyProperties(g, VideoList);
            return VideoList;
        }).collect(Collectors.toList());
        vo.setVideosSets(UPVideoSetVo);
        return vo;
    }
}
