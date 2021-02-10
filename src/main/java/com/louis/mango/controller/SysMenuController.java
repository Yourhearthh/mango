package com.louis.mango.controller;

import com.louis.mango.common.FileUtils;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.model.SysMenu;
import com.louis.mango.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@Api(value = "菜单控制器")
@RestController
@RequestMapping("menu")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;

    @PostMapping("/save")
    @ApiImplicitParam(value = "新增菜单")
    public HttpResult addMenu(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.save(record));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records) {
        return HttpResult.ok(sysMenuService.delete(records));
    }

    @GetMapping(value="/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @GetMapping(value="/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }

    @PostMapping(value="/exportExcelMenu")
    public void exportExcelMenu(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysMenuService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }
}
