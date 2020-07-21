package com.aaa.controller;



//测绘管理--单位基本信息--技术人员信息


import com.aaa.model.Technicist;
import com.aaa.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechnicistController {
    @Autowired
    private TechnicistService technicistService;

    //获取技术人员信息
    @RequestMapping("/qureyTechnicist")
    public List<Technicist> qureyTechnicist(@RequestParam("userId") Long userId){
        List<Technicist> technicist = technicistService.qureyTechnicist(userId);
        if (null != technicist){
            return technicist;
        }
        return null;
    }


    //修改技术人员信息
    @RequestMapping("/updateTechnicist")
    public Boolean updateTechnicist(@RequestBody Technicist technicist){
        return technicistService.updataTechnicist(technicist);
    }
}
