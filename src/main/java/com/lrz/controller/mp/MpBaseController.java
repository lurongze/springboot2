package com.lrz.controller.mp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class MpBaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    // 小程序sessionKey
    protected String sessionKey;
    protected String AppId;
    protected String AppSecret;
    @Resource
    HttpServletRequest httpServletRequest;
    // 每个方法之前执行的方法
    @ModelAttribute
    void beforeActions() {
        this.sessionKey = httpServletRequest.getHeader("authorization");
        this.AppId = httpServletRequest.getHeader("appid");
        this.AppSecret = "42c52740e810efbf5ce86e2356cba231";
    }
}
