package com.aaa.controller;

import com.aaa.model.Dept;
import com.aaa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //根据parentId查询该部门即子部门
    @RequestMapping("/sleectAllDeptByParentId")
    public List<Dept> selectAllDeptByParentId(@RequestParam("parentId") Integer parentId){
        // 调用 deptService 中的 selectAllDeptByParentId 方法，得到查询结果
        List<Dept> allDept = deptService.selectAllDeptByParentId(parentId);
        if (allDept != null) {
            // 说明结果不为空，返回查询的结果
            return allDept;
        }else {
            // 返回null
            return null;
        }
    }

    //根据部门名称，创建时间，查询部门信息
    @RequestMapping("/selectDeptInfoByField")
    public List<Dept> selectDeptInfoByField(@RequestBody Map map) {
        // 调用 deptService 中的 selectDeptInfoByField 方法，得到查询结果
        List<Dept> deptList = deptService.selectDeptInfoByField(map);
        // 判断 结果是否为空
        if (deptList != null) {
            // 说明结果不为空，查询成功，返回查询的结果
            return deptList;
        }else {
            // 查询失败，返回null
            return null;
        }
    }

    //新增部门信息
    @RequestMapping("/insertDept")
    public Boolean insertDept(@RequestBody Dept dept) {
        // 调用 deptService 中的 insertDept 方法，得到结果
        Boolean aBoolean = deptService.insertDept(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，新增成功，返回true
            return true;
        }else {
            // 新增失败，返回false
            return false;
        }
    }

    //通过主键，删除部门
    @RequestMapping("/deleteDeptByPrimaryKey")
    public Boolean deleteDeptByPrimaryKey(@RequestBody Dept dept) {
        // 调用 deptService 中的 deleteDeptByPrimaryKey 方法，得到结果
        Boolean aBoolean = deptService.deletDeptByprimaryKey(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，删除成功 返回true
            return true;
        }else {
            // 删除失败，返回false
            return false;
        }
    }

    //根据主键，批量删除
    @RequestMapping("/batchDeleteByPrimaryKey")
    public Boolean batchDeleteByPrimaryKey(@RequestBody List<Object> ids) {
        // 调用 deptService 中的 batchDeleteByPrimaryKey 方法，得到结果
        Boolean aBoolean = deptService.batchDeleteByPrimaryKey(ids);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，删除成功 返回true
            return true;
        }else {
            // 删除失败，返回false
            return false;
        }
    }

    //通过主键，修改部门信息
    @RequestMapping("/updateDeptByPrimaryKey")
    public Boolean updateDeptByPrimaryKey(@RequestBody Dept dept) {
        // 调用 deptService 中的 updateDeptByPrimaryKey 方法，得到结果
        Boolean aBoolean = deptService.updateDeptByPrimaryKey(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，修改成功 返回true
            return true;
        }else {
            // 修改失败，返回false
            return false;
        }
    }



}
