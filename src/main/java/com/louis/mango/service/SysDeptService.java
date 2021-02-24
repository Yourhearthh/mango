package com.louis.mango.service;

import com.louis.mango.core.service.CurdService;
import com.louis.mango.model.SysDept;

import java.util.List;

public interface SysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构树
     * @param
     * @return
     */
    List<SysDept> findTree();
}
