package com.lrz.controller;

import com.lrz.utils.Result;
import com.lrz.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gz000172 on 2018/5/14.
 */
@RestController
@RequestMapping("/")
public class IndexController extends BaseController{
    @GetMapping("/index")
    public Result index() {
        return Response.success("list-action");
    }
}
