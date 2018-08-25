package com.lrz.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.ProductType;
import com.lrz.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
* Created by CodeGenerator on 2018/08/25.
*/
@RestController
@RequestMapping("/admin/product/type")
public class ProductTypeController {

    private final ProductTypeService productTypeService;
    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }


    @PostMapping("/add")
    public Result add(ProductType productType) {
        productTypeService.save(productType);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(defaultValue = "0") Integer id) {
        // productTypeService.deleteById(id);
        ProductType productType = productTypeService.findById(id);
        byte isDelete = 1;
        productType.setIsDelete(isDelete);
        productTypeService.update(productType);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ProductType productType) {
        productTypeService.update(productType);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        ProductType productType = productTypeService.findById(id);
        return ResultGenerator.genSuccessResult(productType);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        // List<ProductType> list = productTypeService.findAll();
        Condition condition = new Condition(ProductType.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        // condition.and().andEqualTo("fisuse" ,"1");
        List<ProductType> list = productTypeService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
    * @return 返回实体的结构
    */
    @GetMapping("/entity")
    public Result entity() {
        ProductType productTypeEntity = new ProductType();
        byte isShow = 1;
        productTypeEntity.setUnionId("0");
        productTypeEntity.setIsShow(isShow);
        return ResultGenerator.genSuccessResult(productTypeEntity);
    }
}
