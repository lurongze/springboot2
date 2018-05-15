package com.lrz.controller;

import com.github.pagehelper.PageInfo;
import com.lrz.model.User;
import com.lrz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gz000172 on 2018/5/14.
 */
@RestController
@RequestMapping("/")
public class IndexController extends BaseController{
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public PageInfo<User> index() {
        return userService.getUsers(500, 20);
    }
}
