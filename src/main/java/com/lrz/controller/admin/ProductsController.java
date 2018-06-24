package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.Products;
import com.lrz.service.ProductsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/06/24.
*/
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Resource
    private ProductsService productsService;

    @PostMapping
    public Result add(@RequestBody Products products) {
        productsService.save(products);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Products products = productsService.findById(id);
        byte isDelete = 1;
        products.setIsDelete(isDelete);
        productsService.update(products);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Products products) {
        productsService.update(products);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Products products = productsService.findById(id);
        return ResultGenerator.genSuccessResult(products);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Products> list = productsService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}