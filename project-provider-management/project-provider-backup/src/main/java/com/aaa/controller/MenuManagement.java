package com.aaa.controller;

import com.aaa.model.MenuInfo;
import com.aaa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuManagement {

    @Autowired
    private MenuService menuService;

    //查询子菜单
    @PostMapping("/selectMenu")
    public List MenuInfo(@RequestBody MenuInfo menuInfo){
        try {
            List list = menuService.selectMenu(menuInfo);
            if (list.size() > 0 ) {
                    return list;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
