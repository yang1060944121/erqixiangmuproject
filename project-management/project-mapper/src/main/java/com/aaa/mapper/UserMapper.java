package com.aaa.mapper;

import com.aaa.model.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;

public interface UserMapper extends Mapper<User> {
    public HashMap<String,Object> selectId(@Param("username") String username);
}
