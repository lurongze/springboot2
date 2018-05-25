package com.lrz.service;

import com.lrz.mapper.UserMapper;
import com.lrz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Created by gz000172 on 2018/5/14.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
