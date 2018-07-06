package com.lrz.controller;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.OpenUser;
import com.lrz.service.OpenUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by CodeGenerator on 2018/06/12.
*/
@RestController
@RequestMapping("/open/user")
public class OpenUserController {
    @Autowired
    private OpenUserService openUserService;

    @PostMapping
    public Result add(@RequestBody OpenUser openUser) {
        openUserService.save(openUser);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        openUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OpenUser openUser) {
        openUserService.update(openUser);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        OpenUser openUser = openUserService.findById(id);
        return ResultGenerator.genSuccessResult(openUser);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OpenUser> list = openUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
