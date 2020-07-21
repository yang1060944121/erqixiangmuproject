package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.SpecialPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialPostController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    //获取特殊岗位人员信息
    @RequestMapping("/qureySpecialPost")
    public ResultData selectSpecialPost(@RequestParam("userId") Long userId){
        try {
            //根据userID查询信息
            List<SpecialPost> specialPosts = iProjectService.selectSpecialPost(userId);
            return getSuccess(specialPosts);
        }catch (Exception e){
            e.printStackTrace();
        }
        return getFalse();
    }
}
