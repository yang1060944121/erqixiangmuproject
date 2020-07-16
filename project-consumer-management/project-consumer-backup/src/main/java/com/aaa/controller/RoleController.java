package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "角色管理",tags = "角色管理接口")
public class RoleController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //查询所有角色信息
    @RequestMapping("selectAllRole")
    public ResultData selectAllRole(Integer pageNo, Integer pageSize){
        PageInfo pageInfo = iProjectService.selectAllRole(pageNo,pageSize);
        if (!"".equals(pageInfo) && pageInfo != null) {
            return super.getSuccess(pageInfo);
        }
        return super.getFalse();
    }


}
