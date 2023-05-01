package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.service.FriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("获取关注列表")
    @GetMapping("getFollowing/{id}")
    public R getFollowing(HttpServletRequest request, @PathVariable Integer id){
        return service.getFollowing(request,id);
    }

    @ApiOperation("获取粉丝列表")
    @GetMapping("getFollowers/{id}/{page}/{pageSize}")
    public R getFollowers(HttpServletRequest request, @PathVariable Long pageSize, @PathVariable Long page, @PathVariable Integer id){
        return service.getFollowers(request,page,pageSize,id);
    }

    @ApiOperation("获取粉丝和关注")
    @GetMapping("followCount/{id}")
    public R followCount( @PathVariable String id){
        return service.followCount(id);
    }
    @ApiOperation("取消关注")
    @DeleteMapping("followCancel/{id}")
    public R followCancel( @PathVariable("id") Integer id , HttpServletRequest request){
        return service.followCancel(id,request);
    }

    @ApiOperation("关注状态")
    @DeleteMapping("followStatus/{id}")
    public R followStatus( @PathVariable("id") Integer id , HttpServletRequest request){
        return service.followStatus(id,request);
    }
    @ApiOperation("关注")
    @PostMapping("follow/{id}")
    public R follow(@PathVariable Long id,HttpServletRequest request){
        return service.follow(id,request);
    }
}

