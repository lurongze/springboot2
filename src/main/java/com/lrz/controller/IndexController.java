package com.lrz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gz000172 on 2018/5/14.
 */
@RestController
@RequestMapping("/")
public class IndexController extends BaseController{
    @GetMapping("/index")
    public String index() {
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
