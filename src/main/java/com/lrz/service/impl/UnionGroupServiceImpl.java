package com.lrz.service.impl;

import com.lrz.dao.UnionGroupMapper;
import com.lrz.model.UnionGroup;
import com.lrz.service.UnionGroupService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class UnionGroupServiceImpl extends AbstractService<UnionGroup> implements UnionGroupService {
    @Autowired
    private UnionGroupMapper unionGroupMapper;

}
