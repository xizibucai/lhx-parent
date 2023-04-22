package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.query.VideoQuery;
import com.lhx.dm.user.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-04-01
 */
@Api(tags = "视频详情")
@RestController
@RequestMapping("/user/video")
@CrossOrigin
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ApiOperation("视频详情list")
    @GetMapping("videoGetList")
    public R videoGetList(){
        return videoService.videoGetList();
    }
    @ApiOperation("视频详情list分页")
    @GetMapping("videoGetListPage/{pageNo}/{pageSize}")
    public R videoGetListPage(
            @PathVariable Long pageNo,
            @PathVariable Long pageSize,
            @RequestBody VideoQuery videoQuery){
        return videoService.videoGetListPage(pageNo,pageSize,videoQuery);
    }

    @ApiOperation("视频简略信息")
    @GetMapping("videoLittle")
    public R videoLittle(){
        return videoService.videoLittle();
    }

    @ApiOperation("视频id查询")
    @GetMapping("videoFrontGetById/{id}")
    public R videoFrontGetById(@PathVariable Integer id){
        return videoService.videoFrontGetById(id);
    }




}

