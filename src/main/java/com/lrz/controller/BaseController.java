package com.lrz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/5/14.
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String authSession;

    @Autowired
    HttpServletRequest httpServletRequest;
    @ModelAttribute
    void beforeEveryAction() {
        this.authSession = "123";
        System.out.println("beforeAction:" + httpServletRequest.getMethod());
    }

}
