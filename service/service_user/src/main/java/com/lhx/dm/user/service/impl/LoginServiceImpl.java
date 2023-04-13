package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Login;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.mapper.LoginMapper;
import com.lhx.dm.user.service.LoginService;
import com.lhx.dm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author hc
 * @version 1.0
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {
    @Autowired
    private UserService userService;
    @Override
    public R login(Login login, HttpSession session) {
        System.out.println("login" + login);
        String account = login.getAccount();
        String password = login.getPassword();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account", account);
        wrapper.eq("password", password);
        User user = null;
        try {
            user = userService.getOne(wrapper);
        } catch (Exception e) {
            return R.error().message("登录失败");
        }

        session.setAttribute("user",user);
        return R.ok().data("user", user);
    }

}
