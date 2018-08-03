package com.lrz.service.impl;

import com.lrz.dao.UserRoleMapper;
import com.lrz.model.UserRole;
import com.lrz.service.UserRoleService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/08/03.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

}
