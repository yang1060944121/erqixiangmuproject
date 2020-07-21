package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DeptController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //根据parentID，查询部门即子部门
    @RequestMapping("/getAllDeptByparentId")
    public ResultData<Dept> getAllDeptByparentId (Long parentId)  {
        //调用 iProjectService 中的 selectAllDeptByparentID ,得到查询结果
        List<Dept> deptList = iProjectService.selectAllDeptByParentId(parentId);
        // 判断 结果是否为空
        if (deptList != null) {
            // 说明查询成功，使用系统消息
            return getSuccess(deptList);
        }else {
            // 查询失败，使用系统消息
            return getFalse();
        }
    }

    //根据部门名称，创建时间
    @RequestMapping("/getDeptInfoByField")
    public ResultData<Dept> getDeptInfoByField(@RequestBody Map map) {
        // 调用 iProjectService 中的 selectDeptInfoByField 方法，得到查询结果
        List<Dept> deptList = iProjectService.selectDeptInfoByField(map);

        // 判断 结果是否为空
        if (deptList != null) {
            // 说明查询成功，使用系统消息
            return getSuccess(deptList);
        }else {
            // 查询失败，使用系统消息
            return getFalse();
        }
    }


    //新增部门信息
    @RequestMapping("/addDept")
    public ResultData<Dept> addDept(Dept dept) {
        // 调用 iProjectService 中的 insertDept 方法，得到添加结果
        Boolean aBoolean = iProjectService.insertDept(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明新增成功，使用系统消息
            return addSuccess();
        }else {
            // 新增失败，使用系统消息
            return addFalse();
        }
    }


    //根据主键，删除操作
    @RequestMapping("/deleteDeptByPrimaryKey")
    public ResultData<Dept> deleteDeptByPrimaryKey(Dept dept) {
        // 调用 iProjectService 中的 deleteDeptByPrimaryKey 方法，得到删除结果
        Boolean aBoolean = iProjectService.deleteDeptByPrimaryKey(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明删除成功，使用系统消息
            return deleteSuccess();
        }else {
            // 删除失败，使用系统消息
            return deleteFalse();
        }
    }

    //批量删除
    @RequestMapping("/batchDeleteByPrimaryKey")
    public ResultData<Dept> batchDeleteByPrimaryKey(List<Object> ids) {
        // 调用 iqyService 中的 batchDeleteByPrimaryKey 方法，得到删除结果
        Boolean aBoolean = iProjectService.batchDeleteByPrimaryKey(ids);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明删除成功，使用系统消息
            return deleteSuccess();
        }else {
            // 删除失败，使用系统消息
            return deleteFalse();
        }
    }


    //通过主键，修改部门信息
    @RequestMapping("/updateDeptByPrimaryKey")
    public ResultData<Dept> updateDeptByPrimaryKey(Dept dept) {
        // 调用 iProjectService 中的 batchDeleteByPrimaryKey 方法，得到修改结果
        Boolean aBoolean = iProjectService.updateDeptByPrimaryKey(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明删除成功，使用系统消息
            return updateSuccess();
        }else {
            // 删除失败，使用系统消息
            return updateFalse();
        }
    }


}
