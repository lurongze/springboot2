package com.lrz.controller.mp;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.Products;
import com.lrz.service.ProductSpecificationService;
import com.lrz.service.ProductTypeService;
import com.lrz.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result list() {
        List<Products> list = productsService.getList(this.unionId, null, null, null);
        return ResultGenerator.genSuccessResult(list);
    }
}
