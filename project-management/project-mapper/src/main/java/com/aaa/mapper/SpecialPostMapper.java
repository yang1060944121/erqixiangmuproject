package com.aaa.mapper;

import com.aaa.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecialPostMapper extends Mapper<SpecialPost> {
    List<SpecialPost> selectSpecialPost(Long userId);
}