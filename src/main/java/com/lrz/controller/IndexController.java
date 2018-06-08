package com.lrz.controller;

import com.lrz.core.RedisService;
import com.lrz.wechat.MiniService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by gz000172 on 2018/5/14.
 */
@RestController
@RequestMapping("/")
public class IndexController extends BaseController{
    @Resource
    private RedisService redisService;
    @Resource
    private MiniService miniService;
    @GetMapping("/index")
    public String index() {
        redisService.setStr("testKey", "list-action" + new Date().toString());
        return "list-action";
    }

    @GetMapping("/test-post")
    public String testPost() {
        String res = miniService.testPost();
        logger.info("res: " + res);
        return "test-interceptor";
    }

    @GetMapping("/test-get")
    public String testGet() {
        String res = miniService.testGet();
        logger.info("res: " + res);
        return "test-interceptor";
    }

    @GetMapping("/test-init")
    public String testInit() {
        System.out.println("authSession:" + this.authSession);
        return this.authSession;
    }
}
