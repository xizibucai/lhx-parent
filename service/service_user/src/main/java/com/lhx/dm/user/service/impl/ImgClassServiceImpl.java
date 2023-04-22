package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.ImgClass;
import com.lhx.dm.user.vo.ImageClassVo;
import com.lhx.dm.user.mapper.ImgClassMapper;
import com.lhx.dm.user.service.ImgClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
@Service
public class ImgClassServiceImpl extends ServiceImpl<ImgClassMapper, ImgClass> implements ImgClassService {

    //查询分类
    @Override
    public R getImgClass() {
        List<ImgClass> classList = list();
        return R.ok().data("classList",classList);
    }
    //添加图片类别
    @Override
    public R addImgClass(ImgClass imgClass) {
        boolean isSuccess = this.save(imgClass);
        return isSuccess ? R.ok() : R.error();
    }
    //逻辑删除图片类别
    @Override
    public R deleteImgClass(Integer id) {
        boolean isSuccess = this.removeById(id);
        return isSuccess ? R.ok() : R.error();
    }
    //修改图片类别
    @Override
    public R updateImgClass(ImgClass imgClass) {
        boolean isSuccess = updateById(imgClass);
        return isSuccess ? R.ok() : R.error();
    }

    @Override
    public R getAllImageForPage(Long pageNo, Long pageSize, ImageClassVo imageClassVo) {
        String type = imageClassVo.getType();
        String begin = imageClassVo.getBegin();
        String end = imageClassVo.getEnd();

        QueryWrapper<ImgClass> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("create_time", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("update_time", end);
        }

        if (!StringUtils.isEmpty(type)){
            queryWrapper.like("type", type);
        }
        Page<ImgClass> page = new Page<>(pageNo, pageSize);

        baseMapper.selectPage(page,queryWrapper);
        List<ImgClass> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total",total).data("list",records);

    }


}
