package com.louis.mango.service.impl;

import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import com.louis.mango.dao.SysDeptMapper;
import com.louis.mango.model.SysDept;
import com.louis.mango.service.SysDeptService;
import com.louis.mango.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Autowired
    SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDept> findTree() {
        List<SysDept> deptList = new ArrayList<>();
        List<SysDept> depts = sysDeptMapper.findAll();
        for (SysDept dept : depts) {
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                deptList.add(dept);
            }
        }
        findChildren(deptList, depts);
        return deptList;
    }

    private void findChildren(List<SysDept> deptList, List<SysDept> depts) {
        for (SysDept sysDept : deptList) {
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept : depts) {
                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
                    dept.setParentName(sysDept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }

    @Override
    public int save(SysDept record) {
        if (record.getId() == null || record.getId() == 0) {
            record.setCreateBy(SecurityUtils.getUsername());
            return sysDeptMapper.insertSelective(record);
        }
        return sysDeptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDept> records) {
        for (SysDept dept : records) {
            delete(dept);
        }
        return 1;
    }

    @Override
    public SysDept findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}
