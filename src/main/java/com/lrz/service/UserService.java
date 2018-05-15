package com.lrz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.mapper.UserMapper;
import com.lrz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gz000172 on 2018/5/14.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public PageInfo<User> getUsers(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.selectList();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
