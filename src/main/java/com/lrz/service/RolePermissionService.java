package com.lrz.service;
import com.lrz.model.RolePermission;
import com.lrz.core.Service;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/08/09.
 */
public interface RolePermissionService extends Service<RolePermission> {
    void updatePermission(Integer roleId, List<String> values);
}
