package com.lrz.dao;

import com.lrz.core.Mapper;
import com.lrz.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends Mapper<User> {

    User findByUserName(@Param("userName") String userName);
}