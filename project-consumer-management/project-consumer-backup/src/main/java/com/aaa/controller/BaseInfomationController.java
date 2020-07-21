package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Mapping_unit;
import com.aaa.model.ResultCommit;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//测绘管理----单位基本信息
@RestController
@Api(value = "单位基本信息", tags = "单位基本信息")
public class BaseInfomationController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //单位基本信息详情
    @RequestMapping("/qureyMapping_unit")
    public ResultData qureyMapping_unit(@RequestParam("userId") Long userId){
        //根据userID查询单位信息
        List<Mapping_unit> mapping_units = iProjectService.qureyMapping_unit(userId);
        //判断查询结果是否为空
        if (null!=mapping_units){
            //如果不为空就返回查询数据
            return super.getSuccess(mapping_units);
        }
        //为空就返回查询失败信息
        return super.getFalse();
    }

    //测绘成果详情
    @GetMapping("/selectResultDetails")
    public ResultData<ResultCommit> selectResultDetails(Long id) {
        ResultCommit resultCommit = iProjectService.selectResultDetails(id);
        if (resultCommit != null) {
            return getSuccess(resultCommit);
        }else {
            return getFalse();
        }
    }

}
