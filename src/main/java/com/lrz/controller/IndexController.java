package com.lrz.controller;

import com.lrz.core.RedisService;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.User;
import com.lrz.service.UserService;
import com.lrz.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lrz on 2018/5/14.
 */
@RestController
@RequestMapping("/")
public class IndexController extends BaseController{
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserService userService;
    @GetMapping("/index")
    public String index() {
        redisService.setStr("testKey", "list-action" + new Date().toString());
        return "list-action";
    }

    @GetMapping("/dva-data")
    public Result dvaData() {
        return ResultGenerator.genSuccessResult("dva-data");
    }

    @GetMapping("/http-test")
    public Result httpTest() {
        String res = "";
        try{
            Map<String, String> params = new HashMap<>();
            params.put("name", "lurongze");
            HttpUtil.httpDoGet("http://127.0.0.1:9011", null, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult(res);
    }

    @PostMapping("/getPost")
    public Result getPost(@RequestParam String name) {
        return ResultGenerator.genSuccessResult(name);
    }

    @GetMapping("/test")
    public Result test() {
        Condition condition = new Condition(User.class);
        condition.createCriteria().andEqualTo("userName", "lurongze");
        condition.and().orEqualTo("userEmail", "1946755280@qq.com");
        condition.and().andGreaterThanOrEqualTo("id", 10);
        condition.selectProperties("id", "userName", "count(1)");
        List<User> userList = userService.findByCondition(condition);

        User user = userService.findByUserName("lurongze");
        System.out.println(user);
        return ResultGenerator.genSuccessResult(userList);
    }

}
