package com.lrz.controller;

import com.lrz.core.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/index")
    public String index() {
        redisService.setStr("testKey", "list-action" + new Date().toString());
        return "list-action";
    }

    @PostMapping("/post")
    public String post() {
        return "test-interceptor";
    }

    @GetMapping("/test-init")
    public String testInit() {
        System.out.println("authSession:" + this.authSession);
        return this.authSession;
    }
}
