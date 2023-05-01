package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.controller.VideoController;
import com.lhx.dm.user.entity.ImageCollection;
import com.lhx.dm.user.entity.Video;
import com.lhx.dm.user.entity.VideosCollection;
import com.lhx.dm.user.entity.VideosSet;
import com.lhx.dm.user.mapper.VideosCollectionMapper;
import com.lhx.dm.user.service.VideoService;
import com.lhx.dm.user.service.VideosCollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.service.VideosSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-16
 */
@Service
public class VideosCollectionServiceImpl extends ServiceImpl<VideosCollectionMapper, VideosCollection> implements VideosCollectionService {

    @Autowired
    private VideosSetService videosSetService;

    @Override
    public R getVideoSetCollection(String id) {
        QueryWrapper<VideosCollection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        List<VideosCollection> collections = baseMapper.selectList(wrapper);
        ArrayList<Integer> videosID = new ArrayList<>();
        for (VideosCollection videos : collections) {
            videosID.add(videos.getVideosId());
        }
        List<VideosSet> videosSets = videosSetService.listByIds(videosID);
        return R.ok().data("videosSets",videosSets);
    }

    @Override
    public R delVideoCollection(Integer id, String userID) {
        QueryWrapper<VideosCollection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userID);
        wrapper.eq("videos_id",id);
        boolean remove = remove(wrapper);
        return R.ok();
    }

    @Override
    public Boolean getVideoStatus(String id, String userID) {
        QueryWrapper<VideosCollection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userID);
        wrapper.eq("videos_id",id);
        VideosCollection one = getOne(wrapper);
        if (one!=null) {
            return true;
        }
        return false;
    }

    @Override
    public R addVideoCollection(Integer id, String userID) {
        QueryWrapper<VideosCollection> wrapper = new QueryWrapper<>();
        VideosCollection collection = new VideosCollection();
        collection.setIsDeleted(false);
        collection.setUserId(Integer.valueOf(userID));
        collection.setVideosId(id);
        boolean save = save(collection);
        return save?R.ok():R.error();
    }
}
