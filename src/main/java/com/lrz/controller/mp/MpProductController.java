package com.lrz.controller.mp;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.ProductSpecification;
import com.lrz.model.ProductType;
import com.lrz.model.Products;
import com.lrz.service.ProductSpecificationService;
import com.lrz.service.ProductTypeService;
import com.lrz.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Created by gz000172 on 2018/9/5.
 */
@RestController
@RequestMapping("/mp/product")
public class MpProductController extends MpBaseController{

    private final ProductsService productsService;
    private final ProductTypeService productTypeService;
    private final ProductSpecificationService productSpecificationService;
    @Autowired
    public MpProductController(ProductsService productsService, ProductTypeService productTypeService, ProductSpecificationService productSpecificationService) {
        this.productsService = productsService;
        this.productTypeService = productTypeService;
        this.productSpecificationService = productSpecificationService;
    }

    @GetMapping("/list")
    public Result list(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Integer size,
            @RequestParam(defaultValue = "0") Integer cid
    ) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        Condition condition = new Condition(Products.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        List<Products> list;
        if (cid > 0) {
            list = productsService.getList(this.unionId, cid, null, null);
        } else {
            list = productsService.getList(this.unionId, null, null, null);
        }
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        Products products = productsService.findById(id);
        if (products != null && this.unionId.equals(products.getUnionId())) {
            ProductType productType = productTypeService.findById(products.getCid());
            Condition condition = new Condition(ProductSpecification.class);
            condition.createCriteria().andEqualTo("productId", id);
            condition.and().andEqualTo("isDelete", 0);
            condition.orderBy("id ASC");
            List<ProductSpecification> specifications = productSpecificationService.findByCondition(condition);
            products.setCatePid(productType.getPid());
            products.setSpecifications(JSON.toJSONString(specifications));
            return ResultGenerator.genSuccessResult(products);
        } else {
            return ResultGenerator.genFailResult("产品不存在");
        }
    }
}
