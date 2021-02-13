package com.louis.mango.service.impl;

import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import com.louis.mango.dao.SysDictMapper;
import com.louis.mango.model.SysDict;
import com.louis.mango.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    SysDictMapper sysDictMapper;
    @Override
    public int save(SysDict record) {
        return 0;
    }

    @Override
    public int delete(SysDict record) {
        return 0;
    }

    @Override
    public int delete(List<SysDict> records) {
        return 0;
    }

    @Override
    public SysDict findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
    }

    @Override
    public SysDict findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }
}
