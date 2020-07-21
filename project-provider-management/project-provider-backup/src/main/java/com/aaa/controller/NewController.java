package com.aaa.controller;


import com.aaa.base.BaseController;
import com.aaa.base.BaseService;
import com.aaa.base.ResultData;
import com.aaa.model.News;
import com.aaa.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;
import java.util.Map;

import static com.aaa.staticproperties.MappingProjectProperties.CODE;
import static com.aaa.staticproperties.MappingProjectProperties.DATA;
import static com.aaa.status.OperationStatus.SUCCESS;

@RestController
public class NewController extends BaseController {

    @Autowired
    private NewsService newsService;

    //查询所有公告
    @RequestMapping("/selectNews")
    public ResultData selectNews(@RequestParam("Id") Long Id) {
        List<News> newsList= newsService.selectNews(Id);
        if (newsList.size() > 0) {
            return getSuccess(newsList);
        }else {
            return getFalse();
        }
    }


    //根据名字模糊查询公告
    @RequestMapping("/selectByTitle")
    public ResultData selectByTitle(String title) {
        Map<String,Object> titles = newsService.selectByTitle(title);
        if (SUCCESS.getCode().equals(titles.get(CODE))) {
            return super.getSuccess(titles.get(DATA));

        } else {
            return super.getFalse();
        }
    }

    //新增公告
    @RequestMapping("/insertNews")
    public ResultData insertNews(@RequestBody News news) {
        if (newsService.insertNews(news)){
            return insertSuccess();
        }else {
            return insertFalse();
        }
    }

    //修改公告
    public ResultData  updateNews(@RequestBody News news){
        Integer update = newsService.updateNews(news);
        if (update>0){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }


    //删除公告
    @RequestMapping("/deleteNews")
    public ResultData <String>  deleteNewsByIds(@RequestParam("ids") List<Long> ids) {
        try {
            newsService.deleteNewsByIds(ids);
            return deleteSuccess();
        } catch (Exception e) {
            return deleteFalse();
        }
    }
}
