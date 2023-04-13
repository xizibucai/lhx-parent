package com.lhx.dm.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Login;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author hc
 * @version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/user/login")
public class UserLoginController {

    @Autowired
    private LoginService service;
    @PostMapping("login")
    public R login(@RequestBody Login login, HttpSession session){
        return service.login(login,session);
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}
