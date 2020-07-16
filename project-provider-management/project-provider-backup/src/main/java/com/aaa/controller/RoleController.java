package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.model.Role;
import com.aaa.service.RoleService;
import com.alibaba.druid.sql.visitor.functions.If;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.AnnotationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    //查询所有角色信息
    @RequestMapping("/selectAllRole")
    public PageInfo selectAllRole(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = roleService.selectAllARole(pageNo,pageSize);
        if (pageInfo != null) {
            return pageInfo;
        }
        return null;
    }

    //根据条件查询
    @RequestMapping("/selectRoleByField")
    public PageInfo selectRoleByField(@RequestBody Map map, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = roleService.selectRoleByField(map,pageNo,pageSize);
        if (!"".equals(pageInfo) && pageInfo != null) {
            return pageInfo;
        }
        return null;
    }

    //根据主键查询角色信息
    @RequestMapping("selectRoleByprimaryKey")
    public Role selectRoleByPrimaryKey(@RequestParam("roleId") Long roleId){
        Role role = roleService.selectRoleByParimaryKey(roleId);
        if (!"".equals(role) && role != null) {
            return role;
        }
        return null;
    }


}
