package com.aaa.service;

import com.aaa.mapper.AuditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//测绘管理--项目审核--项目信息
@Service
public class AuditService {
    @Autowired
    private AuditMapper auditMapper;

    public List selectAuditInfo() {
        List list = auditMapper.selectAuditInfo();
        if (list.size()>0){
            return list;
        }
        return null;
    }

    public List fuzzyQueryAduit( String projectName ) {
        List list = auditMapper.fuzzyQueryAduit(projectName);
        if (list.size()>0){
            return list;
        }
        return null;
    }


}
