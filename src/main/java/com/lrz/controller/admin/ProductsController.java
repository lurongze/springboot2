package com.lrz.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.ProductType;
import com.lrz.model.Products;
import com.lrz.service.ProductTypeService;
import com.lrz.service.ProductsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/08/28.
*/
@RestController
@RequestMapping("/admin/products")
public class ProductsController extends AdminBaseController{

    private final ProductsService productsService;
    private final ProductTypeService productTypeService;
    @Autowired
    public ProductsController(ProductsService productsService, ProductTypeService productTypeService) {
        this.productsService = productsService;
        this.productTypeService = productTypeService;
    }


    @PostMapping("/add")
    public Result add(Products products) {
        Date createdAt = new Date();
        products.setCreatedAt(createdAt);
        productsService.save(products);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(defaultValue = "0") Integer id) {
        // productsService.deleteById(id);
        Products products = productsService.findById(id);
        byte isDelete = 1;
        products.setIsDelete(isDelete);
        productsService.update(products);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Products products) {
        productsService.update(products);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        Products products = productsService.findById(id);
        ProductType productType = productTypeService.findById(products.getCid());
        products.setCatePid(productType.getPid());
        return ResultGenerator.genSuccessResult(products);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        Condition condition = new Condition(Products.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        List<Products> list = productsService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
    * @return 返回实体的结构
    */
    @GetMapping("/entity")
    public Result entity() {
        Products productsEntity = new Products();
        byte isShow = 1;
        byte isRecommend = 0;
        productsEntity.setIsRecommend(isRecommend);
        productsEntity.setIsShow(isShow);
        productsEntity.setSortOrder(50);
        if(StringUtils.isNotEmpty(this.userInfo.getUnionId())) {
            productsEntity.setUnionId(this.userInfo.getUnionId());
        } else {
            productsEntity.setUnionId("0");
        }
        return ResultGenerator.genSuccessResult(productsEntity);
    }
}
