package com.lrz.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/6/5.
 */
public class AdminBaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    // 后台token认证
    protected String token;
    @Resource
    HttpServletRequest httpServletRequest;
    // 每个方法之前执行的方法
    @ModelAttribute
    void beforeActions() {
        this.token = "123";
        System.out.println("beforeAction:" + httpServletRequest.getMethod());
    }
}
