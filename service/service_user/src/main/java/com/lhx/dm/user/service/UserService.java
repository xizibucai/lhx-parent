package com.lhx.dm.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.dm.user.vo.UserFromVo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lhx
 * @since 2023-03-07
 */
public interface UserService extends IService<User> {

    //获取所有用户
    R getAllUser();
    //获取所有用户--分页
    R getAllUserForPage(Page<User> userPage);
    //根据用户id查询用户信息
    R getUserById(Integer id);
    //添加用户
    R addUser(User user);
    //根据id删除用户
    R deleteById(Integer id);
    //修改用户信息
    R updateUser(User user);
    //根据条件获取所有用户--分页
    R getAllUserForSearch(Long pageNo, Long pageSize, UserFromVo userFromVo);

    R userGetGallery(String id);


}
