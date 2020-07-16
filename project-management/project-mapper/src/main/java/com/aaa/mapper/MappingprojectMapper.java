package com.aaa.mapper;

import com.aaa.model.Mappingproject;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MappingprojectMapper extends Mapper<Mappingproject> {
    //查询所有项目信息
    List<Mappingproject> seleztAllMappingProject();

    //根据项目类型查询所有提交项目
    List<Mappingproject> selectAllByResultsstatus(String projectType);

    //根据项目名称模糊查询
    List<Mappingproject> fuzzyProjectName(@Param("projectName") String projectName);


}