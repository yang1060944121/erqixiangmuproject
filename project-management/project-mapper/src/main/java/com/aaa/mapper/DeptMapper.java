package com.aaa.mapper;

import com.aaa.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends Mapper<Dept> {

    //查询部门信息，根据主键id查询部门的信息
    Dept selectDeptByDeptId(Integer deptId);

    //查询所有部门
    List<Dept> selectDeptByParentId(Integer parentId);

    //根据部门名称，创建时间，来查询
    List<Dept> selectDeptInfoByField(Map map);

    //新增部门信息
    int insertDept(Dept dept);
}