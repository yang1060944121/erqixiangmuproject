package com.aaa.service;

import com.aaa.mapper.MenuMapper;
import com.aaa.model.MenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    //查询子菜单
    public List<String> selectMenu(MenuInfo menuInfo){
        BigInteger menu_id = menuInfo.getMenu_id();
        BigInteger parent_id = menuInfo.getParent_id();
        System.out.println(menuInfo);
        return menuMapper.selectMenu(menu_id,parent_id);
    }
}
