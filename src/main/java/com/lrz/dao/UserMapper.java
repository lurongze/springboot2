package com.lrz.dao;

import com.lrz.core.Mapper;
import com.lrz.model.RolePermission;
import com.lrz.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {
    User findByUserName(@Param("userName") String userName);

    List<User> getList(@Param("unionId") String unionId);

}