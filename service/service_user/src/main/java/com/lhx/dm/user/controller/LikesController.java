package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-04-25
 */
@RestController
@RequestMapping("/user/interactive/like")
@CrossOrigin
@Api(tags = "点赞")
public class LikesController {
    @Autowired
    private LikeService service;
    //点赞
    @ApiOperation("点赞")
    @PostMapping("add/{type}/{dmId}")
    public R add(@PathVariable Integer dmId, HttpServletRequest request, @PathVariable String type){
        return service.add(dmId,request,type);
    }
    //取消点赞
    @ApiOperation("取消点赞")
    @DeleteMapping("cancel/{type}/{dmId}")
    public R cancel(@PathVariable Integer dmId,HttpServletRequest request,@PathVariable String type){
        return service.cancel(dmId,request,type);
    }
}

