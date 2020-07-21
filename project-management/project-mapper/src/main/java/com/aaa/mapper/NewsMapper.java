package com.aaa.mapper;

import com.aaa.model.News;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NewsMapper extends Mapper<News> {
    //查询公告
    List<News> selectNews();

    //根据名字模糊查询
    List<News> selectByTitle(String title);

    //添加公告
    Integer insertNews(@Param("news") News news);

    //删除公告
    Integer deleteNewsByIds(List<Long> list);

    //修改公告
    Integer updateNews(@Param("news")News news);

}