package com.louis.mango.service;

import com.louis.mango.core.service.CurdService;
import com.louis.mango.model.SysConfig;

import java.util.List;

public interface SysConfigService extends CurdService<SysConfig> {
    int deleteById(List<Long> ids);

    List<SysConfig> findByLable(String lable);
}
