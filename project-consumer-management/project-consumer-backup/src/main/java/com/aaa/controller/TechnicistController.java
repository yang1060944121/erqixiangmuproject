package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Technicist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnicistController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //获取技术人员信息
    @RequestMapping("/qureyTechnicist")
    public ResultData qureyTechnicist(@RequestParam("userId") Long UserId){
        //根据userID获取技术人员信息
        List<Technicist> technicists = iProjectService.qureyTechnicist(UserId);
        //判断技术人员信息是否为空
        if (null != technicists){
            //不为空就返回带数据的信息
            return getSuccess(technicists);
        }
        return getFalse();
    }


    //修改技术人员信息
    @RequestMapping("/updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Technicist technicist){
        if (iProjectService.updateTechnicist(technicist)){
            //如果为true就返回修改成功信息
            return updateSuccess();
        }
        return updateFalse();
    }



}
