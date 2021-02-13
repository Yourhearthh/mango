package com.louis.mango.dao;

import com.louis.mango.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictMapper {
    List<SysDict> findPageByLabel(@Param("label") String label);

    List<SysDict> findPage();

    SysDict findByLabel(String label);
}
