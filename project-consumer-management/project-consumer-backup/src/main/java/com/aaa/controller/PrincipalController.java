package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Principal;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//测绘管理-单位基本信息--单位负责人
@RestController
@Api(value = "负责人信息")
public class PrincipalController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //获取负责人信息
    @RequestMapping("/qureyPrincipal")
    public ResultData QureyList(@RequestParam("userId") Long userId) {

        List<Principal> principals = iProjectService.queryOne(userId);
        if (null != principals) {
            return getSuccess(principals);
        }
        return getFalse();
    }

    //修改负责人信息
    @RequestMapping("/updateList")
    public ResultData updateList(@RequestBody Principal principal){
        //判断返回的Boolean
        if (iProjectService.updateList(principal)){
            return updateSuccess();
        }
        return updateFalse();
    }

}
