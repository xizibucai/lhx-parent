package com.lhx.dm.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Login;
import com.lhx.dm.user.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @author hc
 * @version 1.0
 */
public interface LoginService extends IService<Login> {
    String login(Login login);

    R getLoginInfo(String memberId);
    // R login(Login login, HttpSession session);
}
