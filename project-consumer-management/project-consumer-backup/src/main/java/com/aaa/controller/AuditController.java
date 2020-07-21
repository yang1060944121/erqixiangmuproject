package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//测绘管理-项目审核--项目信息
@RestController
@Api(value = "项目审核", tags = "项目信息")
public class AuditController extends BaseController {
        @Autowired
    private IProjectService iProjectService;

        //查询登记过的项目信息
    @RequestMapping("/selectAuditInfo")
    public ResultData selectAuditInfo(Integer pageNo, Integer pageSize) {
        PageInfo audits = iProjectService.selectAuditInfo(pageNo,pageSize);
        if (audits == null) {
            return super.getFalse();
        }else {
            return super.getSuccess(audits);
        }
    }

    @RequestMapping("/fuzzyQueryAduit")
    public ResultData fuzzyQueryAduit(Integer pageNo, Integer pageSize,String projectName) {
        PageInfo auditPageInfo = iProjectService.fuzzyQueryAduit(pageNo, pageSize,projectName);
        if (auditPageInfo != null) {
            return super.getSuccess(auditPageInfo);
        }else {
            return super.getFalse();
        }
    }
}
