package com.wzy.mapper;

import com.wzy.pojo.Pdt;

public interface PdtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pdt record);

    int insertSelective(Pdt record);

    Pdt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pdt record);

    int updateByPrimaryKey(Pdt record);
}