package com.lrz.controller.mp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.TbkItem;
import com.lrz.service.TbkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
* Created by CodeGenerator on 2018/09/19.
*/
@RestController
@RequestMapping("/mp/tbk/item")
public class MpTbkItemController {

    private final TbkItemService tbkItemService;
    @Autowired
    public MpTbkItemController(TbkItemService tbkItemService) {
        this.tbkItemService = tbkItemService;
    }


    @PostMapping("/add")
    public Result add(TbkItem tbkItem) {
        tbkItemService.save(tbkItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(defaultValue = "0") Integer id) {
        // tbkItemService.deleteById(id);
        TbkItem tbkItem = tbkItemService.findById(id);
        tbkItemService.update(tbkItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TbkItem tbkItem) {
        tbkItemService.update(tbkItem);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        TbkItem tbkItem = tbkItemService.findById(id);
        return ResultGenerator.genSuccessResult(tbkItem);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        Condition condition = new Condition(TbkItem.class);
        List<TbkItem> list = tbkItemService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
    * @return 返回实体的结构
    */
    @GetMapping("/entity")
    public Result entity() {
        TbkItem tbkItemEntity = new TbkItem();
        return ResultGenerator.genSuccessResult(tbkItemEntity);
    }
}
