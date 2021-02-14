package com.louis.mango.controller;

import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"字典管理接口"})
@RestController
@RequestMapping("/dict")
public class SysDictController {
    @Autowired
    SysDictService sysDictService;

    @PreAuthorize("hasAuthority('sys:dict:view')")
    @ApiOperation(value = "分页查询字典数据", notes = "分页查询字典数据")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:dict:view')")
    @ApiOperation(value = "根据label查询字典数据", notes = "根据label查询字典数据")
    @ApiImplicitParam(name = "label", value = "标签名字", paramType = "query", dataType = "String")
    @GetMapping(value = "/findByLabel")
    public HttpResult findByLabel(@RequestParam("label") String label) {
        return HttpResult.ok(sysDictService.findByLabel(label));
    }


}
