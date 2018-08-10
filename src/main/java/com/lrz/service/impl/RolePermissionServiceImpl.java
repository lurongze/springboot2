package com.lrz.service.impl;

import com.lrz.dao.RolePermissionMapper;
import com.lrz.model.RolePermission;
import com.lrz.service.RolePermissionService;
import com.lrz.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/08/09.
 */
@Service
@Transactional
public class RolePermissionServiceImpl extends AbstractService<RolePermission> implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    @Autowired
    public RolePermissionServiceImpl(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public void updatePermission(Integer roleId, List values) {
        rolePermissionMapper.deletePermissions(roleId);
        rolePermissionMapper.addPermissions(roleId, values);
    }

}
