package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.UnionSetting;
import com.lrz.service.UnionSettingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
* Created by CodeGenerator on 2018/08/24.
*/
@RestController
@RequestMapping("/union/setting")
public class UnionSettingController extends AdminBaseController{

    private final UnionSettingService unionSettingService;
    @Autowired
    public UnionSettingController(UnionSettingService unionSettingService) {
        this.unionSettingService = unionSettingService;
    }


    @PostMapping("/add")
    public Result add(UnionSetting unionSetting) {
        unionSettingService.save(unionSetting);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(defaultValue = "0") Integer id) {
        // unionSettingService.deleteById(id);
        UnionSetting unionSetting = unionSettingService.findById(id);
        byte isDelete = 1;
        unionSetting.setIsDelete(isDelete);
        unionSettingService.update(unionSetting);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UnionSetting unionSetting) {
        unionSettingService.update(unionSetting);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        UnionSetting unionSetting = unionSettingService.findById(id);
        return ResultGenerator.genSuccessResult(unionSetting);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        Condition condition = new Condition(UnionSetting.class);
        condition.createCriteria().andEqualTo("unionId", "0");
        List<UnionSetting> list = unionSettingService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
    * @return 返回实体的结构
    */
    @GetMapping("/entity")
    public Result entity() {
        UnionSetting unionSettingEntity = new UnionSetting();
        unionSettingEntity.setUnionId("0");
        return ResultGenerator.genSuccessResult(unionSettingEntity);
    }
}
