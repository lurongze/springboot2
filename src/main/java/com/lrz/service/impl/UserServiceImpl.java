package com.lrz.service.impl;

import com.lrz.dao.UserMapper;
import com.lrz.model.OpenUser;
import com.lrz.model.User;
import com.lrz.service.UserService;
import com.lrz.core.AbstractService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by CodeGenerator on 2018/06/12.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveOpenUser(OpenUser openUser) {

    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

}
