package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.service.CommentvideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-05-01
 */
@RestController
@CrossOrigin
@Api(tags = "评论")
@RequestMapping("/user/commentvideo")
public class CommentvideoController {

    @Autowired
    private CommentvideoService service;

    @ApiOperation("获取评论列表")
    @GetMapping("getcomments/{vid}/{pageNo}/{pageSize}")
    public R getcomments(@PathVariable Integer vid, @PathVariable("pageNo") Long pageNo,
                         @PathVariable("pageSize") Long pageSize) {
        return service.getcomments(vid,pageNo,pageSize);
    }
    @ApiOperation("添加评论")
    @PostMapping("commentAdd/{vid}/{pid}")
    public R commentAdd(@PathVariable Integer vid){
        // return service.commentAdd();
        return null;
    }




}

