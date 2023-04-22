package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.service.FriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-04-18
 */
@Api(tags = "好友")
@RestController
@Configuration
@RequestMapping("user/friend")
public class FriendController {

    @Autowired
    private FriendService service;

    @ApiOperation("获取好友列表")
    @PostMapping("message/list")
    public R getFriendList(HttpServletRequest request){
        return service.getFriendList(request);
    }
}

