package com.aaa.service;

import com.aaa.base.BaseController;
import com.aaa.mapper.RoleMapper;
import com.aaa.model.Role;
import com.aaa.utils.DataUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Service
public class RoleService extends BaseController {

    @Autowired
    private RoleMapper roleMapper;


    //查询角色信息
    public PageInfo selectAllARole(Integer pageNo, Integer pageSize){
        // 当前页数和一页数量
        PageHelper.startPage(pageNo,pageSize);

        try {
            //查询权限信息
            List<Role> roles = roleMapper.selectAll();
            //判断查询结果是否为空
            if (!"".equals(roles) && null !=roles){
                //将查询结果放入
                PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
                //返回查询结果
                return rolePageInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

        //条件查询
        public PageInfo selectRoleByField(Map map, Integer pageNo, Integer pageSize){
            // 当前页数和一页数量
            PageHelper.startPage(pageNo,pageSize);

            try {
                //查询角色信息
                List<Role> roles = roleMapper.selectRoleByField(map);
                //判断查询结果是否为空
                if(!"".equals(roles) && null !=roles){
                    //将查询结果放入
                    PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
                    return rolePageInfo;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        //根据id查询角色信息
        public Role selectRoleByParimaryKey(Long roleId){
            //判断前段是否传值成功
            if (null !=roleId){
                try {
                    //根据id查询
                    Role role = roleMapper.selectByPrimaryKey(roleId);
                    //判断查询结果是否为空
                    if (!"".equals(role) && null !=role){
                        //返回查询信息
                        return role;
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //新增角色和对应权限
        public Long insertRole(Role role){
            //判断前段是否传值成功
            if (!"".equals(role) && null !=role){
                //将角色名称传入
                role.setRoleName(role.getRoleName())
                        //将角色描述传入
                        .setRemark(role.getRemark())
                        //将创建时间传入
                        .setCreateTime(DataUtils.getCurrentDate());
                //执行新增
                Integer integer = roleMapper.insertRoleResultId(role);
                //获取返回的生成的id
                @NotNull Long roleId = role.getRoleId();
                if (null !=integer){
                    return roleId;
                }
            }
            return null;
        }

}
