package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.UnionGroup;
import com.lrz.service.UnionGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/admin/union/group")
public class UnionGroupController extends AdminBaseController{

    private final UnionGroupService unionGroupService;
    @Autowired
    public UnionGroupController(UnionGroupService unionGroupService) {
        this.unionGroupService = unionGroupService;
    }

    @PostMapping
    public Result add(UnionGroup unionGroup) {
        checkAdmin();
        unionGroup.setUnionId(UUID.randomUUID().toString());
        unionGroupService.save(unionGroup);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        checkAdmin();
        UnionGroup unionGroup = unionGroupService.findById(id);
        byte isDelete = 1;
        unionGroup.setIsDelete(isDelete);
        unionGroupService.update(unionGroup);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(UnionGroup unionGroup) {
        checkAdmin();
        if (StringUtils.isEmpty(unionGroup.getUnionId())) {
            unionGroup.setUnionId(UUID.randomUUID().toString());
        }
        unionGroupService.update(unionGroup);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        checkAdmin();
        UnionGroup unionGroup = unionGroupService.findById(id);
        return ResultGenerator.genSuccessResult(unionGroup);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        checkAdmin();
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
        checkAdmin();
        UnionGroup unionGroupEntity = new UnionGroup();
        return ResultGenerator.genSuccessResult(unionGroupEntity);
    }
}
