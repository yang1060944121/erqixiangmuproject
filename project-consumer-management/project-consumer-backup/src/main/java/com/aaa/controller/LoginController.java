package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.annotation.LoginAnnotation;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.vo.TokenVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(value = "登录信息",tags = "用户登录接口")
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
    @RequestMapping("/doLogin")
    @LoginAnnotation(opeationType = "登录操作",opeationName = "管理员登录")
    public ResultData doLogin(User user) {
        TokenVo tokenVo = projectService.doLogin(user);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        }
        return super.loginFailed();
    }

    /**
     * 登录页面
     */
    @RequestMapping("/doLogin")
    public String doLogin(){
        return "../web/login/login";
    }
}
