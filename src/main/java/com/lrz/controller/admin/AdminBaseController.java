package com.lrz.controller.admin;

import com.lrz.model.User;
import com.lrz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/6/5.
 */
public class AdminBaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    // 用户id
    protected Integer userId;
    protected User userInfo;
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    UserService userService;

    /**
     * 每个方法之前执行的方法
     */
    @ModelAttribute
    void beforeActions() {
        this.userId = Integer.valueOf(httpServletRequest.getAttribute("userId").toString());
        this.userInfo = userService.findById(this.userId);
        System.out.println("beforeAction:this.userId:" + this.userId);
    }
}
