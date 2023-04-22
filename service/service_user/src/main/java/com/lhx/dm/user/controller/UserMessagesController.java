package com.lhx.dm.user.controller;


import com.lhx.db.result.R;
import com.lhx.dm.user.service.UserMessagesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-04-18
 */
@RestController
@Configuration
@Api(tags = "获取私信详细信息")
@RequestMapping("/user/messages")
public class UserMessagesController {

    @Autowired
    private UserMessagesService service;

    @GetMapping("details/{fid}")
    public R details(HttpServletRequest request, @PathVariable String fid){
        return service.details(request,fid);
    }

}

