package com.lrz.controller;

import com.lrz.core.RedisService;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.User;
import com.lrz.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by lrz on 2018/5/14.
 */
@RestController
@RequestMapping("/")
public class IndexController extends BaseController{
    @Resource
    private RedisService redisService;
    @Resource
    private UserService userService;
    @GetMapping("/index")
    public String index() {
        redisService.setStr("testKey", "list-action" + new Date().toString());
        return "list-action";
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
