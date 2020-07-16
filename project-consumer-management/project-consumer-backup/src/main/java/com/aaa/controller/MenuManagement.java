package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.MenuInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuManagement extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    //子菜单查询
    @PostMapping
    @ApiOperation(value = "查询菜单",notes = "查询子菜单信息")
    public ResultData MenuInfo(MenuInfo menuInfo){
        List list = iProjectService.MenuInfo(menuInfo);
        if (list.size() > 0  ) {
            return super.getSuccess(list);
        }
            return super.getFalse();

    }




}
