package com.lrz.service;
import com.lrz.model.Products;
import com.lrz.core.Service;


/**
 * Created by CodeGenerator on 2018/08/28.
 */
public interface ProductsService extends Service<Products> {
    Integer insert(Products products);
}
