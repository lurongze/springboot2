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

    /**
     * 每个方法之前执行的方法
     */
    @ModelAttribute
    void beforeAction() {
        // 获取用户的sessionKey，这里的key值是系统根据微信接口返回加密过的key值，要获取微信的sessionKey，调用miniService.findOpenUserBySession
        this.sessionKey = httpServletRequest.getHeader("authorization");
        System.out.println("this.sessionKey:" + this.sessionKey);
        this.AppId = httpServletRequest.getHeader("appid"); // 获取appID，再根据appID获取app secret
        this.AppSecret = "42c52740e810efbf5ce86e2356cba231";
    }
}
