package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.NewsMapper;
import com.aaa.model.News;
import com.aaa.status.OperationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.staticproperties.MappingProjectProperties.*;


@Service
public class NewsService extends BaseService<News> {
    @Autowired
    private NewsMapper newsMapper;

    //查询所有公告
    public List<News> selectNews() {
        return newsMapper.selectNews();
    }

    //根据名字模糊查询公告
    public Map<String,Object> selectByTitle(String title) {
        Map<String,Object> titles =new HashMap<>();
        List<News> newsTitle = newsMapper.selectByTitle(title);
        if (newsTitle.size() > 0 ) {
            titles.put(CODE, OperationStatus.SUCCESS.getCode());
            titles.put(MSG,OperationStatus.SUCCESS.getMsg());
            titles.put(DATA,newsTitle);
        }else {
            titles.put(CODE, OperationStatus.FAILED.getCode());
            titles.put(MSG, OperationStatus.FAILED.getMsg());
        }
        return titles;
    }

    //新增公告
    public Boolean insertNews(News news) {

        try {
            Date date = new Date();
            news.setTitle(news.getTitle())
                    .setDigest(news.getDigest())
                    .setBody(news.getBody())
                    .setGmtCreate(date);
            int insert = newsMapper.insert(news);
            if (insert > 0){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    //修改公告
    public Integer updateNews(News news) {
        Integer updateNews = newsMapper.updateByPrimaryKeySelective(news);
        if (updateNews >0 ) {
            return updateNews;
        }else {
            return 0;
        }
    }

    //删除公告
    public Integer deleteNewsByIds(List<Long> ids) {
        Integer delNews=newsMapper.deleteNewsByIds(ids);
        if (delNews >0 ) {
            return delNews;
        }else {
            return  0;
        }
    }



}
