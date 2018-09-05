package com.lrz.service;
import com.lrz.model.Products;
import com.lrz.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/08/28.
 */
public interface ProductsService extends Service<Products> {

    List<Products> getList(String unionId,Integer cid, Integer isShow, Integer isRecommend);

    Integer insert(Products products);
}
