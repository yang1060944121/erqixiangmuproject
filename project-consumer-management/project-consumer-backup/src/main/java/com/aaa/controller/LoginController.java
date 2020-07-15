package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.annotation.LoginAnnotation;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController extends BaseController {

    @Autowired
    private IProjectService projectService;
    /**
     * @author s
     * @description
     *      执行登录操作
     * @param [user]
     * @date 2020/7/15
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登录操作",opeationName = "管理员登录")
    public ResultData doLogin(User user) {
        return projectService.doLogin(user);
    }
}
