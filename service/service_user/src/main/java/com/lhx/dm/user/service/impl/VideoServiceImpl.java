package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.entity.Video;
import com.lhx.dm.user.entity.query.VideoQuery;
import com.lhx.dm.user.entity.vo.VideoBaseVo;
import com.lhx.dm.user.entity.vo.video.ResourceVo;
import com.lhx.dm.user.mapper.VideoMapper;
import com.lhx.dm.user.service.UserService;
import com.lhx.dm.user.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-04-01
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {



    @Override
    public R videoGetList() {
        List<Video> list = list();
        return R.ok().data("list", list);
    }

    @Override
    public R videoGetListPage(Long pageNo, Long pageSize, VideoQuery videoQuery) {
        Page<Video> page = new Page<>(pageNo, pageSize);
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();

        baseMapper.selectPage(page, queryWrapper);
        List<Video> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("list", records);

    }

    @Override
    public R videoLittle() {
        List<Video> list = list();
        List<VideoBaseVo> vos = new ArrayList<>();
        for (Video video : list) {
            VideoBaseVo vo = new VideoBaseVo();
            vo.setId(video.getId());
            vo.setTitle(video.getName());
            vo.setCover(video.getImage());
            vos.add(vo);
        }
        return R.ok().data("videos", vos);
    }

    @Override
    public R videoFrontGetById(Integer id) {
        ResourceVo vo = new ResourceVo();
        Video video = getById(id);
        vo.setId(video.getId().toString());
        vo.setOriginal(video.getVideoSourceId());
        return R.ok().data("optResource", vo);
    }
}
