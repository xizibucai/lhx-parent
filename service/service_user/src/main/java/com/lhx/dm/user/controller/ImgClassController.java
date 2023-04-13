package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.entity.ImgClass;
import com.lhx.dm.user.entity.vo.ImageClassVo;
import com.lhx.dm.user.entity.vo.UserFromVo;
import com.lhx.dm.user.service.ImgClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description 图片类别
 *
 * @author lhx
 * @since 2023-03-11
 */
@Api(tags = "图片类别")
@RestController
@CrossOrigin
@RequestMapping("/user/imgclass")
public class ImgClassController {
    @Autowired
    private ImgClassService classService;

    @ApiOperation("添加图片类别")
    @PostMapping("addImgClass")
    public R addImgClass(@RequestBody ImgClass imgClass) {
        return classService.addImgClass(imgClass);
    }

    @ApiOperation("删除图片类别")
    @DeleteMapping("deleteImgClass/{id}")
    public R deleteImgClass(@PathVariable Integer id) {
        return classService.deleteImgClass(id);
    }

    @ApiOperation("修改图片类别")
    @PostMapping("updateImgClass")
    public R updateImgClass(@RequestBody ImgClass imgClass) {
        return classService.updateImgClass(imgClass);
    }

    @ApiOperation("查询图片类别")
    @GetMapping("getImgClass")
    public R getImgClass() {
        return classService.getImgClass();
    }
    @ApiOperation("id查询图片类别")
    @GetMapping("getImgClassById/{id}")
    public R getImgClassById(@PathVariable("id") Integer id){
        ImgClass imageclass = classService.getById(id);
        return R.ok().data("imageclass",imageclass);
    }

    @ApiOperation("待条件查询所有用户--分页")
    @PostMapping("getAllImageForPage/{pageNo}/{pageSize}")
    public R getAllImageForPage(@PathVariable("pageNo") Long pageNo,
                                @PathVariable("pageSize") Long pageSize,
                                @RequestBody ImageClassVo imageClassVo) {
        return classService.getAllImageForPage(pageNo, pageSize, imageClassVo);
    }
}

