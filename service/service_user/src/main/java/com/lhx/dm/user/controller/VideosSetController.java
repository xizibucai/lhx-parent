package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.entity.VideosSet;
import com.lhx.dm.user.query.VideoSetFrontQuery;
import com.lhx.dm.user.query.VideoSumQuery;
import com.lhx.dm.user.service.VideosSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 视频集合 前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-03-19
 */
@Api(tags = "视频集合")
@RestController
@RequestMapping("/user/videosSet")
@CrossOrigin
public class VideosSetController {

    @Autowired
    private VideosSetService videosSetService;

    @ApiOperation("视频集合添加")
    @PostMapping("videosSetAdd")
    public R videosSetAdd(@RequestBody VideosSet videosSet){
        return videosSetService.videosSetAdd(videosSet);
    }

    @ApiOperation("视频集合逻辑删除")
    @DeleteMapping("videosSetDelete/{id}")
    public R videosSetDelete(@PathVariable("id") Integer id){
        return videosSetService.videosSetDelete(id);
    }

    @ApiOperation("视频集合修改")
    @PostMapping("videosSetUpdate")
    public R videosSetUpdate(@RequestBody VideosSet videosSet){
        return videosSetService.videosSetUpdate(videosSet);
    }

    @ApiOperation("视频集合查询")
    @GetMapping("videosSetList")
    public R videosSetList(){
        return videosSetService.videosSetList();
    }

    @ApiOperation("视频集合查询")
    @PostMapping("videosSetListPage/{pageNo}/{pageSize}")
    public R videosSetListPage(@PathVariable("pageNo") Long pageNo,
                               @PathVariable("pageSize") Long pageSize, @RequestBody VideoSumQuery videosSet){

        return videosSetService.videosSetListPage(pageNo,pageSize,videosSet);
    }

    @ApiOperation("影集id查询")
    @GetMapping("videoSetGetById/{id}")
    public R videoSetGetById(@PathVariable Integer id){
        VideosSet videosSet = videosSetService.getById(id);
        return R.ok().data("videosSet",videosSet);
    }

    @ApiOperation("影集最终确认修改状态")
    @PostMapping("videoSetPublish/{id}")
    public R videoSetPublish(@PathVariable Long id){
        return videosSetService.videoSetPublish(id);

    }
    @ApiOperation("影集最终确认列表")
    @GetMapping("videoSetPublishList/{id}")
    public R videoSetPublishList(@PathVariable Long id){
        return videosSetService.videoSetPublishList(id);
    }

    @ApiOperation("影集基本信息列表")
    @GetMapping("videoSetBaseList")
    public R videoSetBaseList(){
        return videosSetService.videoSetBaseList();
    }

    @ApiOperation("前台影集信息")
    @PostMapping("videoSetGetFrontList/{pageNo}/{pageSize}")
    public R videoSetGetFrontList(@PathVariable Long pageSize, @PathVariable Long pageNo,  @RequestBody VideoSetFrontQuery videoSetFrontQuery){
       return videosSetService.videoSetGetFrontList(pageNo,pageSize,videoSetFrontQuery);
    }

    @ApiOperation("影集id查视频列表")
    @GetMapping("videoGetBysetId/{id}")
    public R videoGetBysetId(@PathVariable("id") Integer id){
        return videosSetService.videoGetBysetId(id);
    }


}

