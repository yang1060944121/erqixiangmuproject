package com.aaa.controller;

import com.aaa.model.SpecialPost;
import com.aaa.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialPostController {
    @Autowired
    private SpecialPostService specialPostService;

    //获取特殊岗位人员信息
    @RequestMapping("/qureySpecialPost")
    public List<SpecialPost> selectSpecialPost(@RequestParam("userId") Long userId){
        try {
            //根据userID查询信息
            List<SpecialPost> specialPosts = specialPostService.selectSpecialPost(userId);
            return specialPosts;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
