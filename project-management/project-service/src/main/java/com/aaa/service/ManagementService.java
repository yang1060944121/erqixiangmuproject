package com.aaa.service;

import com.aaa.mapper.ProjectInfoMapper;
import com.aaa.model.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ManagementService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    //项目管理--根据项目类型查询
    public List<ProjectInfo> SelectInfo(){
        List<ProjectInfo> list = new ArrayList<>();
        try {
            list = projectInfoMapper.selectAll();
            if (list.size()>0){
                return list;
            }else {
                System.out.println("数据库没信息");
            }
        }catch (Exception e){
            System.out.println("系统维护中");
        }
        return list;
    }

    //通过id查询项目
    public ProjectInfo selectById(Long id){
        try {
            if (!"".equals(id)){
                //根据id获取项目信息
                ProjectInfo manProject = projectInfoMapper.selectByPrimaryKey(id);
                //判断是否存在该项目
                if (!"".equals(manProject) && null != manProject){
                    return manProject;
                }else {
                    return null;
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改项目
    public Integer updateById(ProjectInfo manProject){

        int i = 0;
        try {

            if (!"".equals(manProject)){
                //执行修改的方法 返回受影响的行数
                i = projectInfoMapper.updateByPrimaryKey(manProject);
                //判断受影响的行数
                if (i>0){
                    return i;
                }else {
                    //再次执行修改操作
                    int j = projectInfoMapper.updateByPrimaryKey(manProject);
                    if (j>0){
                        return j;
                    }
                }
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //根据项目类型进行查询
    public List<ProjectInfo> getInfoByType(String projectType) {
        List<ProjectInfo> list = null;
        try {
            list = projectInfoMapper.getInfoByType(projectType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != list && list.size() > 0) {
            return list;
        }else {
            return null;
        }
    }

    //新增项目
    public int insertInfo(ProjectInfo projectInfo) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 19 ;i++){
            buffer.append(random.nextInt(10));
        }
        Long id =Long.parseLong(String.valueOf(buffer));
        projectInfo.setId(id);
        try {
            int i  = projectInfoMapper.insert(projectInfo);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
