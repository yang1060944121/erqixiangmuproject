package com.aaa.mapper;

import com.aaa.model.ProjectInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProjectInfoMapper extends Mapper<ProjectInfo> {
    //项目管理
    //根据项目类型进行查询
    List<ProjectInfo> getInfoByType(String projectType);
}