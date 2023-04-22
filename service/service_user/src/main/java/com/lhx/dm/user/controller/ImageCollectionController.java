package com.lhx.dm.user.controller;



import com.lhx.db.result.R;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.service.ImageCollectionService;
import com.lhx.dm.user.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-04-15
 */
@RestController
@RequestMapping("/user/imageCollection")
@Api(tags = "收藏")
public class ImageCollectionController {
    @Autowired
    private ImageCollectionService service;

    @ApiOperation("用户id获取收藏图集")
    @GetMapping("imgCollectionGetUserId")
    public R imgCollectionGetUserId(HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);

        return service.imgCollectionGetUserId(memberId);
    }

    @ApiOperation("图集取消收藏")
    @DeleteMapping("delCollection/{galleryId}")
    public R delCollection(@PathVariable String galleryId,HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);

        return service.delCollection(galleryId,memberId);
    }
}

