package com.lrz.service.impl;

import com.lrz.dao.ProductSpecificationMapper;
import com.lrz.model.ProductSpecification;
import com.lrz.service.ProductSpecificationService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/08/31.
 */
@Service
@Transactional
public class ProductSpecificationServiceImpl extends AbstractService<ProductSpecification> implements ProductSpecificationService {
    @Autowired
    private ProductSpecificationMapper productSpecificationMapper;

}
