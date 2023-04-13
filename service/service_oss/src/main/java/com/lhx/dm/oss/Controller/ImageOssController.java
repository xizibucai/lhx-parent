package com.lhx.dm.oss.Controller;



import com.lhx.db.result.R;
import com.lhx.dm.oss.service.ImageOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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

    //上传头像的方法
    @ApiOperation("上传头像")
    @PostMapping("upload")
    public R uploadImgOssFile(@RequestPart("file") MultipartFile file){
        //获取上传文件
        String url= imageOssService.upload(file);

        return R.ok().data("url",url);
    }


}
