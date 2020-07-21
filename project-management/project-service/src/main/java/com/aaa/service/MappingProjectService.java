package com.aaa.service;


import com.aaa.base.BaseService;
import com.aaa.mapper.MappingprojectMapper;
import com.aaa.model.Mappingproject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingProjectService extends BaseService<Mappingproject> {
    @Autowired
    private MappingprojectMapper mappingprojectMapper;

    //查询所有的项目
    public List<Mappingproject> selectAllMappingProject(){
        List<Mappingproject> mappingprojectList = null;
        try {
            mappingprojectList = mappingprojectMapper.seleztAllMappingProject();
        }catch (Exception e){
            e.printStackTrace();
        }
        //判断，结果不为空，即返回数据
        if (mappingprojectList != null && mappingprojectList.size() > 0) {
            return mappingprojectList;
        }else {
            return null;
        }
    }

    //根据项目类型进行查询
    public List<Mappingproject> selectAllByProjectType(String projectType){
        List<Mappingproject> mappingprojectList = null;
        try {
            //调用mappingProjetMapper selectAllByProjectType，返回结果
            mappingprojectList = mappingprojectMapper.selectAllByProjectType(projectType);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 判断 如果结果不为空并且结果的个数大于0，返回拿到的数据
        if (null != mappingprojectList && mappingprojectList.size() > 0) {
            // 说明结果不为空，返回查询的数据
            return mappingprojectList;
        }else {
            // 返回null
            return null;
        }
    }





    //分页查询
    public PageInfo selectALLByPage(Mappingproject mappingProject, Integer pageNo, Integer pageSize) {
        PageInfo<Mappingproject> projectPageInfo = null;
        try {
            // 调用重写的分页查询方法，得到分页结果
            projectPageInfo = queryListByPage(mappingProject, pageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null == projectPageInfo && "".equals(projectPageInfo)) {
            // 说明查询的结果是空，没有数据，返回null
            return null;
        }else {
            // 返回结果
            return projectPageInfo;
        }
    }

    //分页查询方法

    @Override
    public PageInfo<Mappingproject> queryListByPage(Mappingproject mappingproject, Integer pageNo, Integer pageSize) {
        List<Mappingproject> select = null;
        PageInfo<Mappingproject> pageInfo = null;
        try {
            // 设置分页，pageNO 当前页数，pageSize 每页数据个数
            PageHelper.startPage(pageNo, pageSize);
            // 使用自定义的sql语句，返回查询结果
            select = mappingprojectMapper.seleztAllMappingProject();
            // 将查询的结果 进行分页
            pageInfo = new PageInfo<Mappingproject>(select);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        // 判断 结果是否为空
        if (null == pageInfo && "".equals(pageInfo)){
            // 说明结果是空，返回null
            return null;
        }else {
            // 返回 分页结果
            return pageInfo;
        }
    }


}
