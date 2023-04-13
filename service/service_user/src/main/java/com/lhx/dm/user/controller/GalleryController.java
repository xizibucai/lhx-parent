package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Gallery;
import com.lhx.dm.user.entity.vo.GalleryVo;
import com.lhx.dm.user.service.GalleryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
@Api(tags = "图集")
@RestController
@CrossOrigin
@RequestMapping("/user/gallery")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @ApiOperation("图集新增")
    @PostMapping("galleryAdd")
    public R galleryAdd(@RequestBody Gallery gallery) {
        return galleryService.galleryAdd(gallery);
    }

    @ApiOperation("图集查询")
    @GetMapping("galleryList")
    public R galleryList(HttpSession session) {
        return galleryService.galleryList(session);
    }

    @ApiOperation("图集删除")
    @DeleteMapping("galleryDelById/{id}")
    public R galleryDelById(@PathVariable("id") Integer id) {
        return galleryService.galleryDelById(id);
    }

    @ApiOperation("图集修改")
    @PostMapping("galleryUpdate")
    public R galleryUpdate(@RequestBody Gallery gallery) {
        return galleryService.galleryUpdate(gallery);
    }

    @ApiOperation("图集id查")
    @PostMapping("galleryListById/{id}")
    public R galleryListById(@PathVariable("id") Integer id) {
        Gallery gallery = galleryService.getById(id);
        return R.ok().data("gallery", gallery);
    }

    @ApiOperation("图集条件查询")
    @PostMapping("galleryListPage/{pageNo}/{pageSize}")
    public R galleryListPage(@PathVariable("pageNo") Long pageNo,
                             @PathVariable("pageSize") Long pageSize, @RequestBody GalleryVo galleryVo) {
        return galleryService.galleryListPage(pageNo,pageSize,galleryVo);

    }
    @ApiOperation("图集下的所有图片")
    @PostMapping("imageListByGalleryId/{id}")
    public R imageListByGalleryId(@PathVariable("id") Integer id) {
        return galleryService.imageListByGalleryId(id);

    }
    @ApiOperation("发布确认信息")
    @GetMapping("galleryPublish/{id}")
    public R galleryPublish(@PathVariable Integer id){
        return galleryService.galleryPublish(id);
    }

    @ApiOperation("修改最终发布状态")
    @PostMapping("galleryUpdateStatus/{id}")
    public R galleryUpdateStatus(@PathVariable Long id){
        Gallery gallery = galleryService.getById(id);
        gallery.setStatus(1);//
        galleryService.updateById(gallery);
        return R.ok();
    }

}

