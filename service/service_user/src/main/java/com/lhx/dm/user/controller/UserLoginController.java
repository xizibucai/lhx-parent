package com.lhx.dm.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Login;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.service.LoginService;
import com.lhx.dm.user.service.UserService;
import com.lhx.dm.user.utils.JwtUtils;
import com.lhx.dm.user.vo.uservo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author hc
 * @version 1.0
 */
@RestController
@CrossOrigin
@Api(tags = "登录")
@RequestMapping("/user/login")
public class UserLoginController {

    @Autowired
    private LoginService service;
    @Autowired
    private UserService userService;
    @ApiOperation("登录")
    @PostMapping("login")
    public R login(@RequestBody Login login, HttpSession session){
        // return service.login(login,session);
        String token =  service.login(login);
        return R.ok().data("token", token);
    }
    //根据token获取用户信息
    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("auth/getLoginInfo")
    public R getLoginInfo(HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        return service.getLoginInfo(memberId);
    }

    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}
