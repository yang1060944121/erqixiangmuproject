package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.SpecialPostMapper;
import com.aaa.model.SpecialPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SpecialPostService extends BaseService<SpecialPost> {
    @Autowired
    private SpecialPostMapper specialPostMapper;

    //获取特殊人员信息
    public List<SpecialPost> selectSpecialPost(@RequestParam("userId") Long userId){

        try{
            if (!"".equals(userId)){
                List<SpecialPost> specialPosts = specialPostMapper.selectSpecialPost(userId);
                if (null != specialPosts && !"".equals(specialPosts)){
                    return specialPosts;
                }
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
