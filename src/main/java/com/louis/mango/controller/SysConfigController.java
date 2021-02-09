package com.louis.mango.controller;

import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.model.SysConfig;
import com.louis.mango.service.SysConfigService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config")
public class SysConfigController {

    @Autowired
    SysConfigService sysConfigService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysConfig sysConfig) {
        return HttpResult.ok(sysConfigService.save(sysConfig));
    }

    @GetMapping("/findById")
    public HttpResult findById(Long id) {
        return HttpResult.ok(sysConfigService.findById(id));
    }

    @PostMapping(value="/deleteById")
    public HttpResult deleteById(@RequestBody List<Long> ids) {
        return HttpResult.ok(sysConfigService.deleteById(ids));
    }

    @GetMapping(value="/findByLable")
    @ApiImplicitParam(name = "lable", value = "主题标签")
    public HttpResult findByLable(@RequestParam String lable) {
        return HttpResult.ok(sysConfigService.findByLable(lable));
    }

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }


}
