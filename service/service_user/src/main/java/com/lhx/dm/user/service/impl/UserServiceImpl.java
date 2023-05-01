package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Gallery;
import com.lhx.dm.user.entity.Image;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.entity.VideosSet;
import com.lhx.dm.user.vo.UserFromVo;
import com.lhx.dm.user.mapper.UserMapper;
import com.lhx.dm.user.service.GalleryService;
import com.lhx.dm.user.service.ImageService;
import com.lhx.dm.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.service.VideosSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lhx
 * @since 2023-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private VideosSetService videosSetService;

    //获取所有用户
    @Override
    public R getAllUser() {
        List<User> list = this.list();
        return R.ok().data("list", list);
    }

    //获取所有用户--分页
    @Override
    public R getAllUserForPage(Page<User> userPage) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Page<User> page = baseMapper.selectPage(userPage, queryWrapper);
        List<User> records = userPage.getRecords();
        long total = userPage.getTotal();
        return R.ok().data("total", total).data("list", records);
    }

    //根据用户id查询用户信息
    @Override
    public R getUserById(Integer id) {
        User user = this.getById(id);
        return R.ok().data("user", user);
    }

    //添加用户
    @Override
    public R addUser(User user) {
        boolean isSuccess = save(user);
        return isSuccess ? R.ok().data("isSuccess", isSuccess) : R.error().data("isSuccess", isSuccess);
    }

    //根据id删除用户
    @Override
    public R deleteById(Integer id) {
        boolean isSuccess = this.removeById(id);
        return isSuccess ? R.ok().data("isSuccess", isSuccess) : R.error().data("isSuccess", isSuccess);
    }

    //修改用户信息
    @Override
    public R updateUser(User user) {
        boolean isSuccess = updateById(user);
        return isSuccess ? R.ok().data("isSuccess", isSuccess) : R.error().data("isSuccess", isSuccess);
    }

    //根据条件获取所有用户--分页
    @Override
    public R getAllUserForSearch(Long pageNo, Long pageSize, UserFromVo userFromVo) {
        String name = userFromVo.getUserName();
        Integer grade = userFromVo.getGrade();
        String begin = userFromVo.getBegin();
        String end = userFromVo.getEnd();
        Page<User> userPage = new Page<>(pageNo, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("user_name", name);
        }
        if (!StringUtils.isEmpty(grade)) {
            queryWrapper.eq("grade", grade);
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("create_time", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("update_time", end);
        }

        baseMapper.selectPage(userPage, queryWrapper);
        List<User> records = userPage.getRecords();
        long total = userPage.getTotal();
        return R.ok().data("total", total).data("list", records);
    }

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
        return R.ok().data("galleries", galleries).data("images",images).data("videosSets",videosSets);
    }




}
