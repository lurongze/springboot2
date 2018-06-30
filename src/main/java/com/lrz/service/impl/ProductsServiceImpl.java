package com.lrz.service.impl;

import com.lrz.dao.ProductsMapper;
import com.lrz.model.Products;
import com.lrz.service.ProductsService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/06/30.
 */
@Service
@Transactional
public class ProductsServiceImpl extends AbstractService<Products> implements ProductsService {
    @Resource
    private ProductsMapper productsMapper;

}
