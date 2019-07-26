package com.wzy.mapper;

import com.wzy.pojo.Functions;

public interface FunctionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Functions record);

    int insertSelective(Functions record);

    Functions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Functions record);

    int updateByPrimaryKey(Functions record);
}