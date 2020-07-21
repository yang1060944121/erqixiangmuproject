package com.aaa.controller;

import com.aaa.model.ProjectInfo;
import com.aaa.service.ManagementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectManagementController {
    @Autowired
    private ManagementService managementService;

    @RequestMapping("/selectProjectInfo")
    public PageInfo ProjectManagement(@RequestBody PageInfo pageInfo){
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<ProjectInfo> list = this.managementService.SelectInfo();
        PageInfo<ProjectInfo> info = new PageInfo(list);
        return info;
    }

    //通过id查询项目
    @RequestMapping("/selectById")
    public ProjectInfo selectById(@RequestParam("id") Long id){
        try {
            ProjectInfo manProject = managementService.selectById(id);
            if (!"".equals(manProject) && null != manProject){
                return manProject;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //通过id修改项目
    @RequestMapping("/updateById")
    public Integer updateById(@RequestBody ProjectInfo manProject){
        try {
            Integer integer = managementService.updateById(manProject);
            return integer;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //通过项目类型查询
    @RequestMapping("/getInfoByType")
    public List<ProjectInfo> getInfoByType(@RequestParam("ProjectType") String projectType){
        List<ProjectInfo> infos = managementService.getInfoByType(projectType);
        if (infos == null){
            return null;
        }else {
            return infos;
        }
    }

    //新增项目
    @RequestMapping("/insertInfo")
    int insertInfo(@RequestBody ProjectInfo projectInfo){
        return managementService.insertInfo(projectInfo);
    }

}
