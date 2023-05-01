package com.lhx.dm.user.controller;

import com.lhx.db.result.R;
import com.lhx.dm.user.query.DanMuQuery;
import com.lhx.dm.user.service.DanmuService;
import com.lhx.dm.user.vo.DanMuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author hc
 * @version 1.0
 */
@Api(tags = "弹幕接口")
@Configuration
@RestController
@RequestMapping("user/vi/video")
public class DanMuController {
    @Autowired
    private DanmuService service;

    @ApiOperation("获取弹幕")
    @GetMapping("get/{id}")
    public R videoget(@PathVariable Integer id){

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("title","测试");
        map.put("res360","https://www.runoob.com/try/demo_source/movie.mp4");
        map.put("res480","https://www.runoob.com/try/demo_source/movie.mp4");
        map.put("res720","https://www.runoob.com/try/demo_source/movie.mp4");
        map.put("res1080","https://www.runoob.com/try/demo_source/movie.mp4");
        map.put("original","https://www.runoob.com/try/demo_source/movie.mp4");
        map.put("duration",0);
        map.put("review",2000);
        map.put("original","https://www.runoob.com/try/demo_source/movie.mp4");
        HashMap<String, Object> video = new HashMap<>();
        video.put("vid",1);
        video.put("title","title");
        video.put("cover","cover");
        video.put("desc","desc");
        video.put("created_at","2022-06-06T08:42:13.525Z");
        video.put("copyright","copyright");
        video.put("author",null);
        HashMap<String, Object> user = new HashMap<>();
        user.put("uid",1);
        user.put("email","email");
        user.put("name","name");
        user.put("sign","sign   ");
        user.put("avatar","avatar");
        user.put("birthday","0001-01-01T00:00:00Z");
        user.put("gender",0);
        user.put("role",0);
        video.put("author",user);
        return R.ok().data("map",map).data("video",video);
    }

    @GetMapping("danmu/{vid}")
    public R getdanmu(@PathVariable Integer vid, HttpServletRequest request) {
        return  service.getdanmu(vid,request);
    }

    @PostMapping("danmuAadd")
    @ApiOperation("发送弹幕")
    public R danmuAadd(HttpServletRequest request, @RequestBody DanMuQuery danMuQuery) {

        return service.danmuAadd(request,danMuQuery);

    }
}
