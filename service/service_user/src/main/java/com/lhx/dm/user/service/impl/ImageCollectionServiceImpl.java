package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Gallery;
import com.lhx.dm.user.entity.Image;
import com.lhx.dm.user.entity.ImageCollection;
import com.lhx.dm.user.mapper.ImageCollectionMapper;
import com.lhx.dm.user.service.GalleryService;
import com.lhx.dm.user.service.ImageCollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-15
 */
@Service
public class ImageCollectionServiceImpl extends ServiceImpl<ImageCollectionMapper, ImageCollection> implements ImageCollectionService {
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private ImageService imageService;

    @Override
    public R imgCollectionGetUserId(String id) {
        QueryWrapper<ImageCollection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        List<ImageCollection> collectionList = baseMapper.selectList(wrapper);
        ArrayList<Integer> galleryids = new ArrayList<>();
        ArrayList<Integer> imageids = new ArrayList<>();
        for (ImageCollection collection : collectionList) {
            if (collection.getType().equals("1")) {
                //图集
                galleryids.add(collection.getImageId());
            } else {
                //图片
                imageids.add(collection.getImageId());
            }
        }
        //图集
        List<Gallery> galleryList = galleryService.listByIds(galleryids);
        List<Image> imageList = imageService.listByIds(imageids);
        return R.ok().data("galleryList",galleryList).data("imageList",imageList);
    }

    @Override
    public R delCollection(String galleryId, String id) {
        QueryWrapper<ImageCollection> wrapper = new QueryWrapper<>();
        wrapper.eq("type","1");
        wrapper.eq("image_id",galleryId);
        wrapper.eq("user_id",id);
        boolean remove = remove(wrapper);
        return R.ok();
    }
}
