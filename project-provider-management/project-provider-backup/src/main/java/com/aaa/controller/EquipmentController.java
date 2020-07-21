package com.aaa.controller;

import com.aaa.model.Equipment;
import com.aaa.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //获取仪器信息
    @RequestMapping("/qureyEquipment")
    public List<Equipment> selectEquipment(@RequestParam("userId") Long userId){
        try{
            //根据userID查询仪器设备
            List<Equipment> equipment = equipmentService.selectEquipment(userId);
            return equipment;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
