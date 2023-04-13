package com.lhx.dm.user.oss.Controller;



import com.lhx.db.result.R;

import com.lhx.dm.user.oss.service.ImageOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;


/**
 * @author hc
 * @version 1.0
 */
@Api(tags="阿里云图片文件管理")
@RequestMapping("oss/fileOss")
@CrossOrigin
@RestController
public class ImageOssController {

    @Autowired
    private ImageOssService imageOssService;

    //上传图片的方法
    @ApiOperation("上传图片")
    @PostMapping("upload")
    public R uploadImgOssFile(@RequestPart("file") MultipartFile file){
        //获取上传文件
        String url= imageOssService.upload(file);

        return R.ok().data("url",url);
    }

    //删除OSS图片
    // @ApiOperation("删除OSS图片")
    // @DeleteMapping("OssImageDel/{id}")
    // public R ossImageDel(@PathVariable Long id){
    //     return imageOssService.ossImageDel(id);
    // }

    @ApiOperation("删除OSS图片")
    @DeleteMapping("OssImageDel")
    public R ossImageDel(@RequestParam String url){
        return imageOssService.osssImageDel(url);
    }
}
