package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.ProductSpecification;
import com.lrz.service.ProductSpecificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import java.util.List;

/**
* Created by CodeGenerator on 2018/08/31.
*/
@RestController
@RequestMapping("/product/specification")
public class ProductSpecificationController {

    private final ProductSpecificationService productSpecificationService;
    @Autowired
    public ProductSpecificationController(ProductSpecificationService productSpecificationService) {
        this.productSpecificationService = productSpecificationService;
    }


    @PostMapping("/add")
    public Result add(ProductSpecification productSpecification) {
        productSpecificationService.save(productSpecification);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam(defaultValue = "0") Integer id) {
        // productSpecificationService.deleteById(id);
        ProductSpecification productSpecification = productSpecificationService.findById(id);
        byte isDelete = 1;
        productSpecification.setIsDelete(isDelete);
        productSpecificationService.update(productSpecification);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ProductSpecification productSpecification) {
        productSpecificationService.update(productSpecification);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") Integer id) {
        ProductSpecification productSpecification = productSpecificationService.findById(id);
        return ResultGenerator.genSuccessResult(productSpecification);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        String orderBy = "id ASC";
        PageHelper.startPage(page, size, orderBy);
        // List<ProductSpecification> list = productSpecificationService.findAll();
        Condition condition = new Condition(ProductSpecification.class);
        condition.createCriteria().andEqualTo("isDelete", "0");
        // condition.and().andEqualTo("fisuse" ,"1");
        List<ProductSpecification> list = productSpecificationService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
    * @return 返回实体的结构
    */
    @GetMapping("/entity")
    public Result entity() {
        ProductSpecification productSpecificationEntity = new ProductSpecification();
        productSpecificationEntity.setUnionId("0");
        return ResultGenerator.genSuccessResult(productSpecificationEntity);
    }
}
