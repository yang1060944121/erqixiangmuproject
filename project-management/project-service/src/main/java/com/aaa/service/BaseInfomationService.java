package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.BaseInfomationMapper;
import com.aaa.mapper.ResultCommitMapper;
import com.aaa.model.Mapping_unit;
import com.aaa.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseInfomationService extends BaseService<Mapping_unit> {
    @Autowired
    private BaseInfomationMapper baseInfomationMapper;
    @Autowired
    private ResultCommitMapper resultCommitMapper;

    //单位基本信息查询
    public List<Mapping_unit> qureyMapping_unit(Long userId){
        List<Mapping_unit> mapping_units = baseInfomationMapper.qureyMapping_unit(userId);
        if (null!=mapping_units){
            return mapping_units;
        }
        return null;
    }

    //测绘成果详情
    public ResultCommit selectResultDetails(Long id) {
        ResultCommit resultCommit = null;
        try {
            resultCommit = resultCommitMapper.selectResultDetails(id);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        if (resultCommit != null && !"".equals(resultCommit)) {
            return resultCommit;
        }else {
            return null;
        }
    }
}
