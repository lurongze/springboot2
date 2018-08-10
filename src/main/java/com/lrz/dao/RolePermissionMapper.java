package com.lrz.dao;

import com.lrz.core.Mapper;
import com.lrz.model.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper extends Mapper<RolePermission> {
    void addPermissions(@Param("roleId") Integer roleId, @Param("values") List values);
    void deletePermissions(@Param("roleId") Integer roleId);
}