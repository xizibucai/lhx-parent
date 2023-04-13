package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.entity.Image;
import com.lhx.dm.user.entity.query.ImageQuery;
import com.lhx.dm.user.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-03-11
 */
@Api(tags = "图片")
@RestController
@CrossOrigin
@RequestMapping("/user/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @ApiOperation("新增图片")
    @PostMapping("imageAdd")
    public R imageAdd(@RequestBody Image image){
        return imageService.imageAdd(image);
    }

    @ApiOperation("修改图片")
    @PostMapping("imageUpdate")
    public R imageUpdate(@RequestBody Image image){
        return imageService.imageUpdate(image);
    }

    @ApiOperation("删除图片")
    @DeleteMapping("imageDel/{id}")
    public R imageDel(@PathVariable("id") Integer id){
        return imageService.imageDel(id);
    }

    @ApiOperation("图片列表")
    @GetMapping("imageList")
    public R imageList(){
        return imageService.imageList();
    }

    @ApiOperation("图片列表--分页")
    @PostMapping("imageListPage/{pageNo}/{pageSize}")
    public R imageListPage(@PathVariable Long pageNo, @PathVariable Long pageSize, @RequestBody ImageQuery imageQuery){
        return imageService.imageListPage(pageNo,pageSize,imageQuery);
    }

    @ApiOperation("图片id查询")
    @GetMapping("imageGetById/{id}")
    public R imageGetById(@PathVariable Integer id){
        return imageService.imageGetById(id);
    }

    @ApiOperation("更新图片状态")
    @PostMapping("updateStatus/{status}")
    public R updateStatus(@PathVariable Integer status,@RequestBody List<String> ids){

        return imageService.updateStatus(ids,status);
    }


}

