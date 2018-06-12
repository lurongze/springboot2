package com.lrz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/5/14.
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String authSession;

    @Resource
    HttpServletRequest httpServletRequest;

    /**
     * 每个方法之前执行的方法
     */
    @ModelAttribute
    void beforeAction() {
        this.authSession = "123";
    }

}
