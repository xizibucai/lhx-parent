package com.lhx.dm.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.mapper.UserMapper;
import com.lhx.dm.user.service.UpLoadingService;
import com.lhx.dm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hc
 * @version 1.0
 */
@Service
public class UpLoadingServiceImpl extends ServiceImpl<UserMapper,User> implements UpLoadingService {
    @Autowired
    private UserService userService;

}
