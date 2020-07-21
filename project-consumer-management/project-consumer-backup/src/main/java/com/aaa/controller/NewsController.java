package com.aaa.controller;

import cam.aaa.service.IProjectService;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    //查询公告
    @RequestMapping("/selectNews")
    public List<News> selectNews() {
        return iProjectService.selectNews();
    }

    //模糊查询公告  根据名字
    @RequestMapping("/selectByTitle")
    public ResultData selectByTitle(String title) {
        return iProjectService.selectByTitle(title);
    }

    //新增公告
    @RequestMapping("/insertNews")
    public Integer insertNews(News news) {
        return iProjectService.insertNews(news);
    }

    //删除公告
    @RequestMapping("/deleteNews")
    public Integer deleteNews(List<Integer> ips){
        return iProjectService.deleteNews(ips);
    }

}
