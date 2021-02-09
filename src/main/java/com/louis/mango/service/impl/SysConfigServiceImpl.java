package com.louis.mango.service.impl;

import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;
import com.louis.mango.dao.SysConfigMapper;
import com.louis.mango.model.SysConfig;
import com.louis.mango.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    SysConfigMapper sysConfigMapper;
    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insertSelective(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig sysConfig : records) {
            delete(sysConfig);
        }
        return 1;
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.findById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if(label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPage");
    }

    @Override
    public int deleteById(List<Long> ids) {
        for (Long id : ids) {
            SysConfig sysConfig = findById(id);
            if (sysConfig != null) {
                delete(sysConfig);
            }
        }
        return 1;
    }

    @Override
    public List<SysConfig> findByLable(String lable) {
        List<SysConfig> sysConfigs = sysConfigMapper.findByLable(lable);
        return sysConfigs;
    }
}
