package com.wzy.mapper;

import com.wzy.pojo.RoleFunctions;

public interface RoleFunctionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleFunctions record);

    int insertSelective(RoleFunctions record);

    RoleFunctions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleFunctions record);

    int updateByPrimaryKey(RoleFunctions record);
}