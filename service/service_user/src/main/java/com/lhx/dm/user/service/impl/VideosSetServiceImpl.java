package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Video;
import com.lhx.dm.user.entity.VideosClass;
import com.lhx.dm.user.entity.VideosSet;
import com.lhx.dm.user.query.VideoSetFrontQuery;
import com.lhx.dm.user.query.VideoSumQuery;
import com.lhx.dm.user.vo.VideoSetBaseVo;
import com.lhx.dm.user.vo.VideoSetPublishVo;
import com.lhx.dm.user.vo.uservo.UserUploadVideoVo;
import com.lhx.dm.user.vo.video.VideoSetFrontVo;
import com.lhx.dm.user.mapper.VideosSetMapper;
import com.lhx.dm.user.service.VideoService;
import com.lhx.dm.user.service.VideosClassService;
import com.lhx.dm.user.service.VideosSetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 视频集合 服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-03-19
 */
@Service
public class VideosSetServiceImpl extends ServiceImpl<VideosSetMapper, VideosSet> implements VideosSetService {

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideosClassService videosClassService;

    @Override
    public R videosSetAdd(VideosSet videosSet) {
        save(videosSet);
        return R.ok().data("id", videosSet.getId());
    }

    @Override
    public R videosSetDelete(Integer id) {
        removeById(id);
        return R.ok();
    }

    @Override
    public R videosSetUpdate(VideosSet videosSet) {
        updateById(videosSet);
        return R.ok().data("id", videosSet.getId());
    }

    @Override
    public R videosSetList() {
        List<VideosSet> list = list();
        return R.ok().data("list", list);
    }

    @Override
    public R videosSetListPage(Long pageNo, Long pageSize, VideoSumQuery videosSet) {
        String begin = videosSet.getBegin();
        String end = videosSet.getEnd();
        String title = videosSet.getTitle();
        Integer kind = videosSet.getKind();
        Integer states = videosSet.getStates();
        Integer videosClassId = videosSet.getVideosClassId();
        QueryWrapper<VideosSet> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(kind)) {
            queryWrapper.eq("kind", kind);
        }
        if (!StringUtils.isEmpty(states)) {
            queryWrapper.eq("states", states);
        }
        if (!StringUtils.isEmpty(videosClassId)) {
            queryWrapper.eq("videos_class_id", videosClassId);
        }
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title", title);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("create_time", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("update_time", end);
        }
        Page<VideosSet> page = new Page<>(pageNo, pageSize);
        baseMapper.selectPage(page, queryWrapper);
        long total = page.getTotal();
        List<VideosSet> records = page.getRecords();
        return R.ok().data("total", total).data("list", records);

    }

    @Override
    public R videoSetPublish(Long id) {
        VideosSet videoSet = getById(id);
        videoSet.setPublishStatus(1);
        updateById(videoSet);
        return R.ok();
    }

    @Override
    public R videoSetPublishList(Long id) {
        VideosSet set = getById(id);

        QueryWrapper<Video> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("vides_set_id", id);
        List<Video> videoList = videoService.list(wrapperVideo);

        VideoSetPublishVo vo = new VideoSetPublishVo();
        vo.setVideos(videoList);
        vo.setId(set.getId());
        vo.setUrl(set.getImage());
        vo.setTitle(set.getTitle());
        vo.setStatus(set.getStates());
        vo.setCreateTime(set.getCreateTime());
        vo.setCreateName(set.getCreateName());

        VideosClass videosClass = videosClassService.getById(set.getId());
        String title = videosClass.getTitle();
        vo.setVideosClass(title);
        return R.ok().data("vo", vo);
    }

    @Override
    public R videoSetBaseList() {
        List<VideosSet> list = list();
        List<VideoSetBaseVo> vos = new ArrayList<>();
        for (VideosSet videosSet : list) {
            VideoSetBaseVo vo = new VideoSetBaseVo();
            vo.setId(videosSet.getId().toString());
            vo.setTitle(videosSet.getTitle());
            vo.setCover(videosSet.getImage());
            vos.add(vo);
        }
        return R.ok().data("collection", vos);
    }

    @Override
    public R videoSetGetFrontList(Long pageNo, Long pageSize, VideoSetFrontQuery videoSetFrontQuery) {
        String yearQuery = videoSetFrontQuery.getYear();
        Integer videoClass = videoSetFrontQuery.getVideoClass();
        QueryWrapper<VideosSet> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(videoClass)) {
            wrapper.eq("videos_class_id", videoClass);
        }
        if (!StringUtils.isEmpty(yearQuery)) {
            wrapper.like("first_time", yearQuery);
        }
        Page<VideosSet> page = new Page<>(pageNo, pageSize);
        baseMapper.selectPage(page, wrapper);
        long total = page.getTotal();
        //获取影集信息
        List<VideosSet> videosSetList = page.getRecords();
        if (videosSetList.size() <= 0) {
            return R.ok().data("voList", null).data("total", total).message("没有搜索到结果");
        }
        //封装数据集合
        ArrayList<VideoSetFrontVo> voList = new ArrayList<>();
        //获取影集类型
        List<VideosClass> classList = videosClassService.list();
        //获取影集下视频
        List<Video> videoList = videoService.list();

        for (VideosSet videosSet : videosSetList) {
            VideoSetFrontVo vo = new VideoSetFrontVo();
            //封装分类
            for (VideosClass videosClass : classList) {
                if (videosClass.getId().equals(videosSet.getId())) {
                    vo.setVideoSetClass(videosClass.getTitle());
                    break;
                }
            }
            //封装分集图片
            for (Video video : videoList) {
                vo.getVideoListImage().add(video.getImage());
            }
            //封装影集基本信息
            vo.setId(videosSet.getId());
            vo.setTitle(videosSet.getTitle());
            vo.setOtherTitle(videosSet.getOtherTitle());
            vo.setImage(videosSet.getImage());
            vo.setKind(videosSet.getKind());
            vo.setStates(videosSet.getStates());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(videosSet.getFirstTime());
            int year = calendar.get(Calendar.YEAR);
            vo.setFirstTime(year);
            vo.setCreateName(videosSet.getCreateName());
            voList.add(vo);
        }
        return R.ok().data("voList", voList).data("total", total);


    }

    @Override
    public R videoGetBysetId(Integer id) {
        UserUploadVideoVo vo = new UserUploadVideoVo();
        VideosSet video = getById(id);
        vo.setId(video.getId().toString());
        vo.setTitle(video.getTitle());
        vo.setImage(video.getImage());
        vo.setUsername(video.getCreateName());
        Long statesNum = video.getStates();
        int num = Math.toIntExact(statesNum);
        String states = "";
        switch (num) {
            case 1:
                states = "更新中";
                break;
            case 2:
                states = "完结";
                break;
            case -1:
                states = "停更";
                break;
            default:
                states = "未播放";
        }
        vo.setStatus(states);
        vo.setFirstTime(video.getFirstTime());
        vo.setDescribe(video.getIntro());
        //todo 缺状态

        //视频信息
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("vides_set_id", id);
        List<Video> item = videoService.list(wrapper);
        vo.setVideos(item);

        return R.ok().data("data", vo);
    }


}
