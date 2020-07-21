package com.aaa.controller;

import com.aaa.model.Mappingproject;
import com.aaa.service.MappingProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MappingProjectController {
    @Autowired
    private MappingProjectService mappingProjectService;

    //查询所有项目
    @RequestMapping("/selectAll")
    public List<Mappingproject> selectAllProject(){
        //调用mappingProjectService 中的 selectAllMappingProject 方法获取数据
        List<Mappingproject> mappingprojectList = mappingProjectService.selectAllMappingProject();
        return mappingprojectList;
    }

    //根据项目类型查询项目信息
    @RequestMapping("/selectAllByType")
    public List<Mappingproject> selectAllByType(@RequestParam(value = "projectType",required = false) String projectType){
        // 调用 mappingProjectService 中的 getAllByProjectType 方法，得到结果
        List<Mappingproject> allByType = mappingProjectService.selectAllByProjectType(projectType);
        //判断是否为空
        if (allByType == null) {
            return null;
        }else {
            return allByType;
        }
    }



    // 查询结果分页
    @RequestMapping("/selectAllByPage")
    public PageInfo selectAllByPage(@RequestBody Mappingproject mappingproject,
                                    @RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize){
        //调用mappingProjectService 中的selectAllByPage 方法
        PageInfo pageInfo = mappingProjectService.selectALLByPage(mappingproject,pageNo,pageSize);
        return pageInfo;
    }
}
