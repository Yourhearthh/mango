package com.louis.mango.dao;

import com.louis.mango.model.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysConfigMapper {
    int insertSelective(SysConfig record);

    int updateByPrimaryKeySelective(SysConfig record);

    SysConfig findById(Long id);

    int deleteByPrimaryKey(Long id);

    List<SysConfig> findByLable(String lable);

    List<SysConfig> findPageByLabel(@Param(value="label") String label);

    List<SysConfig> findPage();

}
