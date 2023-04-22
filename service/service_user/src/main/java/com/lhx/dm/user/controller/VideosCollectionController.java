package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.service.VideosCollectionService;
import com.lhx.dm.user.utils.JwtUtils;
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
 * @since 2023-04-16
 */
@RestController
@Configuration
@Api(tags = "影集收藏")
@RequestMapping("/user/videosCollection")
public class VideosCollectionController {
    @Autowired
    private VideosCollectionService service;

    /**
     *
     * @param request   获取当前用户
     * @return R
     */
    @ApiOperation("获取收藏影集")
    @GetMapping("getVideoSetCollection")
    public R getVideoSetCollection(HttpServletRequest request){
        String id = JwtUtils.getMemberIdByJwtToken(request);
        return service.getVideoSetCollection(id);
    }

    /**
     *
     * @param id 移除收藏影集id
     * @param request   获取当前用户
     * @return R
     */
    @ApiOperation("移除收藏")
    @DeleteMapping("delVideoCollection/{id}")
    public R delVideoCollection(@PathVariable Integer id,HttpServletRequest request){
        String userID = JwtUtils.getMemberIdByJwtToken(request);
        return service.delVideoCollection(id,userID);
    }


}

