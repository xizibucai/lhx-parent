package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.VideosClass;
import com.lhx.dm.user.query.VideoClassQuery;
import com.lhx.dm.user.mapper.VideosClassMapper;
import com.lhx.dm.user.service.VideosClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 视频类型 服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-03-19
 */
@Service
public class VideosClassServiceImpl extends ServiceImpl<VideosClassMapper, VideosClass> implements VideosClassService {

    //添加
    @Override
    public R addVideosClass(VideosClass videosClass) {
        boolean save = save(videosClass);
        return R.ok();
    }
    //查询
    @Override
    public R videosClassList(Long pageNo, Long pageSize, VideoClassQuery videoClassQuery) {
        String type = videoClassQuery.getType();
        String begin = videoClassQuery.getBegin();
        String end = videoClassQuery.getEnd();

        QueryWrapper<VideosClass> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("create_time", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("update_time", end);
        }

        if (!StringUtils.isEmpty(type)){
            queryWrapper.like("title", type);
        }
        Page<VideosClass> page = new Page<>(pageNo, pageSize);

        baseMapper.selectPage(page,queryWrapper);
        List<VideosClass> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total",total).data("list",records);
    }

    @Override
    public R videosClassUpdate(VideosClass videosClass) {
        boolean b = updateById(videosClass);
        return R.ok();
    }

    @Override
    public R videosClassDelete(Integer id) {
        boolean b = removeById(id);
        return R.ok();
    }
}
