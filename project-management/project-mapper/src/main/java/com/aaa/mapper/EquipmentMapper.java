package com.aaa.mapper;

import com.aaa.model.Equipment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EquipmentMapper extends Mapper<Equipment> {
    List<Equipment> selectEquipment(Long userId);
}