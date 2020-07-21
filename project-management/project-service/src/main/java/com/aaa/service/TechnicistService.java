package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.TechnicistMapper;
import com.aaa.model.Technicist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TechnicistService extends BaseService<Technicist> {
    @Autowired
    private TechnicistMapper technicistMapper;

    //获取技术人员信息
    public List<Technicist> qureyTechnicist(Long userId){
        //根据userid去查询技术人员信息
        List<Technicist> technicist = technicistMapper.qureyTechnicist(userId);
        if (null != technicist){
            //不为空返回信息
            return technicist;
        }
        return null;
    }

    //修改技术人员信息
    public Boolean updataTechnicist(Technicist technicist){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        Technicist technicist1 = technicist.setId(technicist.getId())
                .setName(technicist.getName())
                .setIdNumber(technicist.getIdNumber())
                .setMajorType(technicist.getMajorType())
                .setSex(technicist.getSex())
                .setAge(technicist.getAge())
                .setMajor(technicist.getMajor())
                .setDuty(technicist.getDuty())
                .setTitleMajor(technicist.getTitleMajor())
                .setModifyTime(format);
        if (null != technicist1){
            int i = technicistMapper.updataTechnicist(technicist1);
            if (i>0){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }


}
