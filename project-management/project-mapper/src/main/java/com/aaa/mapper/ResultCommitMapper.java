package com.aaa.mapper;

import com.aaa.model.ResultCommit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultCommitMapper extends Mapper<ResultCommit> {

    //测绘成果的模糊查询
    List<ResultCommit> fuzzyResultName(@Param("name") String name,
                                       @Param("projectType") String projectType,
                                       @Param("resultDate") String resultDate);

    //测绘成果详情
    ResultCommit selectResultDetails(@Param("id") Long id);

}