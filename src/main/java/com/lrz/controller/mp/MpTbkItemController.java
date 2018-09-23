package com.lrz.controller.mp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.TbkItem;
import com.lrz.model.TbkItemInfo;
import com.lrz.service.TbkItemInfoService;
import com.lrz.service.TbkItemService;
import com.lrz.utils.HttpResult;
import com.lrz.utils.HttpUtil;
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
    private final TbkItemInfoService tbkItemInfoService;
    @Autowired
    public MpTbkItemController(TbkItemService tbkItemService, TbkItemInfoService tbkItemInfoService) {
        this.tbkItemService = tbkItemService;
        this.tbkItemInfoService = tbkItemInfoService;
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
    public Result list(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size,
            @RequestParam(defaultValue = "淘宝") String platform
            ) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        Condition condition = new Condition(TbkItem.class);
        condition.and().andEqualTo("itemPlatform", platform);
        List<TbkItem> list = tbkItemService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/viewDetail")
    public Result viewDetail(@RequestParam(defaultValue = "0") String id){

        Condition condition = new Condition(TbkItemInfo.class);
        condition.createCriteria().andEqualTo("itemId", id);
        List<TbkItemInfo> list = tbkItemInfoService.findByCondition(condition);
        if (list != null && list.size() > 0) {
            TbkItemInfo item = list.get(0);
            return ResultGenerator.genSuccessResult(item.getItemImages());
        }

        try {
            HttpResult res = HttpUtil.httpDoGet("http://localhost:8082/getTbkItem/" + id, null,null );
            String result = res.getBody();
            TbkItemInfo newItem = new TbkItemInfo();
            newItem.setItemId(id);
            newItem.setItemImages(result);
            tbkItemInfoService.save(newItem);
            return ResultGenerator.genSuccessResult(result);
        } catch (Exception e) {
            System.out.println("result:1");
            return ResultGenerator.genFailResult(e.toString());
        }
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
