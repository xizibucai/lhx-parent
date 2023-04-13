package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.entity.VideosClass;
import com.lhx.dm.user.entity.query.VideoClassQuery;
import com.lhx.dm.user.service.VideosClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * <p>
 * 视频类型 前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-03-19
 */
@Api(tags = "视频类型")
@RestController
@CrossOrigin
@RequestMapping("/user/videosClass")
public class VideosClassController {
    @Autowired
    private VideosClassService videosClassService;

    @ApiOperation("视频类型添加")
    @PostMapping("VideosClassadd")
    public R addVideosClass(@RequestBody VideosClass videosClass){
        return videosClassService.addVideosClass(videosClass);
    }

    @ApiOperation("视频类型列表")
    @PostMapping("videosClassList/{pageNo}/{pageSize}")
    public R videosClassList(@PathVariable("pageNo") Long pageNo,
                             @PathVariable("pageSize") Long pageSize, @RequestBody VideoClassQuery videoClassQuery){
        return videosClassService.videosClassList(pageNo,pageSize,videoClassQuery);
    }

    @ApiOperation("视频类型修改")
    @PostMapping("videosClassUpdate")
    public R videosClassUpdate(@RequestBody VideosClass videosClass){
        return videosClassService.videosClassUpdate(videosClass);
    }

    @ApiOperation("视频类型逻辑删除")
    @DeleteMapping("videosClassDelete/{id}")
    public R videosClassDelete(@PathVariable("id") Integer id ){
        return videosClassService.videosClassDelete(id);
    }
    @ApiOperation("视频类型id查")
    @GetMapping("videosClassGetById/{id}")
    public R videosClassGetById(@PathVariable Long id){
        VideosClass videosClass = videosClassService.getById(id);
        return R.ok().data("videosClass",videosClass);

    }
    @ApiOperation("查询分类list")
    @GetMapping("videoClassList")
    public R videoClassList(){
        List<VideosClass> list = videosClassService.list();
        return R.ok().data("classList",list);
    }


}

