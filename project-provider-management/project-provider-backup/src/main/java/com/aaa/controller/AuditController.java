package com.aaa.controller;

import com.aaa.service.AuditService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditController {
    @Autowired
    private AuditService auditService;

    //分页查询项目登记通过的项目信息
    @RequestMapping("/selectAuditInfo")
    PageInfo selectAuditInfo(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize) {
        List list = auditService.selectAuditInfo();
        if (list != null) {
            PageHelper.startPage(pageNo,pageSize);
            return new PageInfo(list);
        }else {
            return new PageInfo();
        }
    }

    //分页模糊查询项目登记通过的项目信息

    @RequestMapping("/fuzzyQueryAduit")
    PageInfo fuzzyQueryAduit(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam("projectName") String projectName) {
        List list = auditService.fuzzyQueryAduit(projectName);
        if (list != null) {
            PageHelper.startPage(pageNo,pageSize);
            return new PageInfo(list);
        }else {
            return new PageInfo();
        }
    }
}
