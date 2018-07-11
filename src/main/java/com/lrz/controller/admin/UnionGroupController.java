package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.UnionGroup;
import com.lrz.service.UnionGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/admin/union/group")
public class UnionGroupController {
    @Autowired
    private UnionGroupService unionGroupService;

    @PostMapping
    public Result add(UnionGroup unionGroup) {
        unionGroupService.save(unionGroup);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        UnionGroup unionGroup = unionGroupService.findById(id);
        byte isDelete = 1;
        unionGroup.setIsDelete(isDelete);
        unionGroupService.update(unionGroup);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(UnionGroup unionGroup) {
        unionGroupService.update(unionGroup);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        UnionGroup unionGroup = unionGroupService.findById(id);
        return ResultGenerator.genSuccessResult(unionGroup);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UnionGroup> list = unionGroupService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * @return 返回实体的结构
     */
    @GetMapping("/entity")
    public Result entity() {
        UnionGroup unionGroupEntity = new UnionGroup();
        return ResultGenerator.genSuccessResult(unionGroupEntity);
    }
}
