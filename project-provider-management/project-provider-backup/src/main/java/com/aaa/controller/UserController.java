package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.model.User;
import com.aaa.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/5/22 14:45
 * @Description
 *负责用户的数据返回
 **/
@RestController
public class UserController extends CommonController<User> {
    @Autowired
    private UserService userService;

    /**
     * @Author wxz
     * @Description 查询所有用户
     * @Param
     * @return
     **/

    @PostMapping("/selectAllUser")
    public PageInfo selectAllUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return userService.selectAllUser(pageNo,pageSize);
    }
    /**
     * @author Seven Lee
     * @description
     * 这是添加用户的方法
     * @param [user]
     * @date 2020/5/22
     * @return java.lang.Boolean
     * @throws
     **/

    @PostMapping("/addUser")
    public Boolean addUser(@RequestBody User user)  {
        try {
            userService.selectListByPage(user,29,7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userService.addUser(user);
    }

    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }
    /**
     * @Author wxz
     * @Description
     * @Param 根据主键删除
     * @return
     **/
    @PostMapping("/deleteUser")
    public Integer deleteUser(@RequestBody User user){
        try {
            Integer delete = userService.deleteUser(user);
            return delete;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author wxz
     * @Description 根据id批量删除用户
     * @Param
     * @return
     **/
    @PostMapping("/delectMoreUser")
    public Integer deleteMoreUser(@RequestBody List<Object> ids){
        return userService.deleteMoreUser(ids);
    }
    /**
     * @Author wxz
     * @Description 根据id查询用户信息
     * @Param
     * @return
     **/
    @GetMapping("/selectUserById")
    public User selectUserById(@RequestParam("id") Long id){
        return userService.selectUserById(id);
    }

    /**
     * @Author wxz
     * @Description 根据id修改用户信息
     * @Param
     * @return
     **/
    @PostMapping("/updateUserById")
    public Integer updateUserById(@RequestBody User user){
        return userService.updateUser(user);
    }

}
