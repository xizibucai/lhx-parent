package com.lhx.dm.user.controller.uploading;

import com.lhx.db.result.R;
import com.lhx.dm.user.service.UpLoadingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hc
 * @version 1.0
 */
@Api(tags = "获取上传资源")
@CrossOrigin
@RequestMapping("/user/loading")
@RestController
public class UserUploadingGet {
    @Autowired
    private UpLoadingService UpLoadingService;
    @ApiOperation("获取用户上传的")
    @GetMapping("userGetList/{id}")
    public R userGetGallery(@PathVariable String id) {
        return UpLoadingService.userGetGallery(id);
    }

}
