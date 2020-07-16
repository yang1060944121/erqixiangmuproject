package com.aaa.controller;


import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Mappingproject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "项目信息" , tags = "项目信息接口")
public class MappingProjectController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    //查询所有项目
    @RequestMapping("/getAll")
    public ResultData<Mappingproject> getAllMapping(){
        //调用iProjectService 中的getAllMappingProject 方法获取数据
        List<Mappingproject> allMapping = iProjectService.selectAllProject();

        //判断结果是否为空
        if (allMapping != null && allMapping.size() > 0) {
            //拿到数据
            return getSuccess(allMapping);
        }else {
            //查询失败，使用系统失败消息
            return getFalse();
        }

    }

    //根据项目汇交类型查询所有汇交项目
    @RequestMapping("/selectAllByResultsstatus")
    public ResultData<Mappingproject> AllByResultsstatus(String Resultsstatus) {
        List<Mappingproject> mappingprojectList = null;
        try {
            //调用iProjectService中的selectAllByResultsstatus方法获取数据
            mappingprojectList = iProjectService.selectAllBYResultsstatus(Resultsstatus);
        }catch (Exception e){
            e.printStackTrace();
        }

        //判断结果是否为空
        if (mappingprojectList != null && mappingprojectList.size() > 0) {
            //拿到数据，返回结果
            return getSuccess(mappingprojectList);
        }else {
            //查询失败，返回系统消息
            return getFalse();
        }
    }





    //重写BaseService中的queryListBypage方法
    @RequestMapping("/selectAllByPage")
    public PageInfo selectAllByPage(Mappingproject mappingproject, Integer pageNo, Integer pageSize){
        return iProjectService.selectAllByPAge(mappingproject,pageNo,pageSize);
    }


}
