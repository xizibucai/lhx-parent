package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.service.CommentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-04-25
 */
@RestController
@Configuration
@Api(tags = "评论")
@RequestMapping("/user/comments")
public class CommentsController {
    @Autowired
    private CommentsService service;

    @ApiOperation("获取评论")
    @GetMapping("getComment/{vid}/{page}/{pageSize}")
    public R getComment(@PathVariable String vid, @PathVariable String page, @PathVariable String pageSize){
        return service.getComment(vid,page,pageSize);
    }


}

