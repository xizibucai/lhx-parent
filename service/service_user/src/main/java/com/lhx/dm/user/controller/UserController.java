package com.lhx.dm.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.entity.vo.UserFromVo;
import com.lhx.dm.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lhx
 * @since 2023-03-07
 */
@Api(tags = "用户管理")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation("查询所有用户")
    @GetMapping("getAllUser")
    public R getAllUser(){
        return userService.getAllUser();
    }
    @ApiOperation("所有用户--分页")
    @PostMapping("getAllUserForPage/{pageNo}/{pageSize}")
    public R getAllUserForPage(@PathVariable("pageNo") Long pageNo, @PathVariable("pageSize") Long pageSize){
        Page<User> userPage = new Page<>(pageNo, pageSize);
        return userService.getAllUserForPage(userPage);
    }
    @ApiOperation("待条件查询所有用户--分页")
    @PostMapping("getAllUserForSearch/{pageNo}/{pageSize}")
    public R getAllUserForSearch(
            @PathVariable("pageNo") Long pageNo,
            @PathVariable("pageSize")Long pageSize,
            @RequestBody UserFromVo userFromVo){
        return userService.getAllUserForSearch(pageNo,pageSize,userFromVo);
    }

    @ApiOperation("用户id查单个用户")
    @GetMapping("getUserById/{id}")
    public R getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
    @ApiOperation("添加用户")
    @PostMapping("addUser")
    public R addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @ApiOperation("根据id删除用户")
    @DeleteMapping("deleteById/{id}")
    public R deleteById(@PathVariable("id") Integer id){
        return userService.deleteById(id);
    }

    @ApiOperation("根据id修改用户")
    @PostMapping("update")
    public R update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ApiOperation("获取用户上传的")
    @GetMapping("userGetList/{id}")
    public R userGetGallery(@PathVariable Integer id){
        return userService.userGetGallery(id);
    }
}

