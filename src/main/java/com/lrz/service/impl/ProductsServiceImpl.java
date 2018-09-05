package com.lrz.service.impl;

import com.lrz.dao.ProductsMapper;
import com.lrz.model.Products;
import com.lrz.service.ProductsService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/08/28.
 */
@Service
@Transactional
public class ProductsServiceImpl extends AbstractService<Products> implements ProductsService {


    private final ProductsMapper productsMapper;
    @Autowired
    public ProductsServiceImpl(ProductsMapper productsMapper) {
        this.productsMapper = productsMapper;
    }

    public List<Products> getList(String unionId, Integer cid, Integer isShow, Integer isRecommend){
        return productsMapper.getList(unionId, cid, isShow, isRecommend);
    }

    public Integer insert(Products products){
        return productsMapper.insert(products);
    }
}
