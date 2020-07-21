package com.aaa.controller;

import com.aaa.model.Mapping_unit;
import com.aaa.model.ResultCommit;
import com.aaa.service.BaseInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//测绘管理 单位基本信息
@RestController
public class BaseInfomationController {
    @Autowired
    private BaseInfomationService baseInfomationService;
    @RequestMapping("/qureyMapping_unit")
    List<Mapping_unit> qureyMapping_unit(@RequestParam("userId") Long userId){
        List<Mapping_unit> mapping_units = baseInfomationService.qureyMapping_unit(userId);
        if (null!=mapping_units){
            return mapping_units;
        }
        return null;
    }

    @RequestMapping("/selectResultDetails")
    public ResultCommit selectResultDetails(@RequestParam("id") Long id) {
        ResultCommit details = baseInfomationService.selectResultDetails(id);
        if (details != null) {
            return details;
        }else {
            return null;
        }
    }


}
