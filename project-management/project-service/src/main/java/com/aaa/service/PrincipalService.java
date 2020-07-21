package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.PrincipalMapper;
import com.aaa.model.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PrincipalService extends BaseService<Principal> {
    @Autowired
    private PrincipalMapper principalMapper;

    //获取负责人信息
    public List<Principal> queryOne(Long userId){
        List<Principal> principal = principalMapper.qureyOne(userId);
        if (null != principal){
            return principal;
        }
        return null;
    }

    //修改负责人信息
    public Boolean updateList(Principal principal){
        //获取时间
        Date date = new Date();
        //设置时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        //获取负责人信息
        Principal principal1 = principal.setId(principal.getId())
                .setType(principal.getType())
                .setName(principal.getName())
                .setIdNumber(principal.getIdNumber())
                .setAge(principal.getAge())
                .setSex(principal.getSex())
                .setMajor(principal.getMajor())
                .setDuty(principal.getDuty())
                .setModifyTime(format);
        if (null != principal1){
            int i = principalMapper.updateList(principal1);
            if (i>0){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }



}
