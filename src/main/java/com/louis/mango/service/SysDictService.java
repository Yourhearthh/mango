package com.louis.mango.service;

import com.louis.mango.core.service.CurdService;
import com.louis.mango.model.SysDict;

public interface SysDictService extends CurdService<SysDict> {
    SysDict findByLabel(String label);
}
