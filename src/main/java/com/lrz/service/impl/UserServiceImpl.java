package com.lrz.service.impl;

import com.lrz.dao.UserMapper;
import com.lrz.model.OpenUser;
import com.lrz.model.User;
import com.lrz.service.UserService;
import com.lrz.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void saveOpenUser(OpenUser openUser) {

    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public List<User> getList(String unionId) {
        return userMapper.getList(unionId);
    }

}
