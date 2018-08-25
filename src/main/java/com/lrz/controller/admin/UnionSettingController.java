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
@RequestMapping("/admin/union/setting")
public class UnionSettingController extends AdminBaseController{

    private final UnionSettingService unionSettingService;
    @Autowired
    public UnionSettingController(UnionSettingService unionSettingService) {
        this.unionSettingService = unionSettingService;
    }

    @PostMapping("/update")
    public Result update(@RequestParam String keyName, @RequestParam String keyValue, @RequestParam String title) {
        Condition condition = new Condition(UnionSetting.class);
        condition.createCriteria().andEqualTo("unionId", this.userInfo.getUnionId());
        condition.and().andEqualTo("keyName", keyName);
        List<UnionSetting> list = unionSettingService.findByCondition(condition);
        if (list != null && list.size() > 0) {
            UnionSetting unionSetting = list.get(0);
            unionSetting.setKeyValue(keyValue);
            unionSettingService.update(unionSetting);
        } else {
            UnionSetting newSetting = new UnionSetting();
            newSetting.setUnionId(this.userInfo.getUnionId());
            newSetting.setKeyName(keyName);
            newSetting.setKeyValue(keyValue);
            newSetting.setTitle(title);
            unionSettingService.save(newSetting);
        }
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/list")
    public Result list() {
        Condition condition = new Condition(UnionSetting.class);
        condition.createCriteria().andEqualTo("unionId", "0");
        List<UnionSetting> list = unionSettingService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
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
