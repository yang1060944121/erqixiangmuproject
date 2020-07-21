package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.ProjectInfo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "项目管理信息", tags = "项目管理接口")
public class ProjectManagementController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //查询信息
    @RequestMapping("/selectProjectInfo")
    public ResultData ProjectManagement(PageInfo pageInfo){
        try {
            PageInfo<List> info = iProjectService.ProjectManagement(pageInfo);
            if (null != info){
                System.out.println("查询成功");
                return super.getSuccess(info);
            }
        }catch (Exception e){
            e.printStackTrace();
            return super.getFalse();
        }
        return super.getFalse();
    }

    //根据id查询
    @RequestMapping("/selectById")
    public ResultData selectProById(Long id){
        ProjectInfo manProject = iProjectService.selectById(id);
        if (!"".equals(manProject) && null != manProject){
            return super.getSuccess(manProject);
        }
        return super.getFalse();
    }

    //根据id修改项目信息
    @RequestMapping("/updateById")
    public ResultData updateById(ProjectInfo manProject){
        Integer integer = iProjectService.updateById(manProject);
        if (integer>0){
            return super.updateSuccess();
        }
        return super.updateFalse();
    }


    //根据项目类型查询
    @RequestMapping("/getInfoByType")
    public ResultData<ProjectInfo> getInfoByType( String projectType) {
        List<ProjectInfo> projectInfos = null;
        try {
            // 调用 iqyService 中的 selectAllByType 方法获取数据
            projectInfos = iProjectService.getInfoByType(projectType);
            return super.getSuccess(projectInfos);
        } catch (IllegalArgumentException e) {
            // 非法参数异常
            e.printStackTrace();
            return super.getFalse();
        }
    }

    //新增项目
    @RequestMapping("/")
    public ResultData<ProjectInfo> insertInfo(ProjectInfo projectInfo){
        int i = iProjectService.insertInfo(projectInfo);
        try {
            if (i>0){
                return super.insertSuccess();
            }
        }catch (Exception e){
            e.printStackTrace();
            return super.insertFalse();
        }
        return super.insertFalse();
    }

}
