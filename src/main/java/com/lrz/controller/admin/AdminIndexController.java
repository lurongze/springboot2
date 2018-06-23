package com.lrz.controller.admin;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.core.ServiceException;
import com.lrz.model.User;
import com.lrz.service.UserService;
import com.lrz.utils.HashCrypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by gz000172 on 2018/6/5.
 */
@RestController
@RequestMapping("/admin/index")
public class AdminIndexController extends AdminBaseController{
    @Resource
    private UserService userService;
    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "error") String type) {
        if("error".equals(type)) {
            throw new ServiceException("type类型错误");
        }
        return "admin-index";
    }

    @PostMapping("/register")
    public Result register(@RequestParam String userName, @RequestParam String userPassword) {
        User checkUser = userService.findByUserName(userName);
        if(checkUser != null) {
            throw new ServiceException("用户名已经注册：" + userName);
        }else {
            Double time = Math.floor(System.currentTimeMillis()/1000);
            User user = new User();
            String encodePassword = HashCrypt.string2MD5(userPassword + "ee" + HashCrypt.string2MD5(userPassword + "xs" + HashCrypt.string2MD5(userPassword + "a"))).toUpperCase();
            user.setUserName(userName);
            user.setUserPassword(encodePassword);
            user.setCreatedAt(time.intValue());
            user.setUserEmail("");
            user.setUserAddress("");
            userService.save(user);
            return ResultGenerator.genSuccessResult("账号注册成功：" + userName);
        }
    }
}
