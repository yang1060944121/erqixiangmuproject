package com.aaa.controller;

import com.aaa.model.Principal;
import com.aaa.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrincipalController {
    @Autowired
    private PrincipalService principalService;

    //获取负责人信息
    @RequestMapping("/queryPrincipal")
    public List<Principal> queryOne(@RequestParam("userId") Long userId){
        List<Principal> principals = principalService.queryOne(userId);
        if (null != principals){
            return principals;
        }
        return null;
    }

    //修改负责人信息
    @RequestMapping("/updateList")
    public Boolean updateList(@RequestBody Principal principal){
        return principalService.updateList(principal);
    }





}
