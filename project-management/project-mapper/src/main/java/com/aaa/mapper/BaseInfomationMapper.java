package com.aaa.mapper;

import com.aaa.model.Mapping_unit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseInfomationMapper extends Mapper<Mapping_unit> {
    List<Mapping_unit> qureyMapping_unit(Long userId);

    //模糊查询测绘单位名称
    List<Mapping_unit> fuzzyUnitName(@Param("unitName") String unitName,
                                     @Param("ownedDistrict") String ownedDistrict,
                                     @Param("qualificationLevel") String qualificationLevel);
}