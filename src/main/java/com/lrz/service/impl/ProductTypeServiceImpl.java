package com.lrz.service.impl;

import com.lrz.dao.ProductTypeMapper;
import com.lrz.model.ProductType;
import com.lrz.service.ProductTypeService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/08/25.
 */
@Service
@Transactional
public class ProductTypeServiceImpl extends AbstractService<ProductType> implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

}
