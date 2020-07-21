package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //获取仪器信息详情
    @RequestMapping("/qureyEquipment")
    public ResultData selectEquipment(@RequestParam("userId") Long userId){
        List<Equipment> equipment = iProjectService.selectEquipment(userId);
        if (null != equipment && !"".equals(equipment)){
            return getSuccess(equipment);
        }
        return getFalse();
    }

}
