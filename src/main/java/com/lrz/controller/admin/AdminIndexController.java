package com.lrz.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.core.ServiceException;
import com.lrz.model.User;
import com.lrz.service.UserService;
import com.lrz.utils.HelperUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.UUID;

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

    /**
     * 注册用户名
     * @param userName 用户名
     * @param userPassword 密码
     * @return result
     */
    @PostMapping("/register")
    public Result register(@RequestParam String userName, @RequestParam String userPassword, @RequestParam(required = false) String unionId) {
        User checkUser = userService.findByUserName(userName);
        if(checkUser != null) {
            throw new ServiceException("用户名已经注册：" + userName);
        }else {
            User user = new User();
            String encodePassword = HelperUtil.encodePassword(userPassword);
            user.setUserName(userName);
            user.setUserPassword(encodePassword);
            user.setCreatedAt(HelperUtil.getTimeStamp());
            user.setUserEmail("");
            user.setUserAddress("");
            if(StringUtils.isEmpty(unionId)) {
                unionId = UUID.randomUUID().toString();
            }
            user.setUnionId(unionId);
            userService.save(user);
            return ResultGenerator.genSuccessResult("账号注册成功：" + userName);
        }
    }

    @PostMapping("/login")
    public Result login(@RequestParam String userName, @RequestParam String userPassword) {
        User user = userService.findByUserName(userName);
        if(user != null) {
            String encodePassword = HelperUtil.encodePassword(userPassword);
            if(encodePassword.equals(user.getUserPassword())) {
                JSONObject userInfo = new JSONObject();
                userInfo.put("id", user.getId());
                userInfo.put("name", user.getUserName());
                Integer time = HelperUtil.getTimeStamp();
                userInfo.put("loginTime", time);
                String IP = HelperUtil.getIpAddr(httpServletRequest);
                userInfo.put("sign", HelperUtil.encodePassword( user.getUserName() + "*" + user.getId() + "*" + IP + "*" + time));
                String token = HelperUtil.Base64Encode(userInfo.toJSONString());
                return ResultGenerator.genSuccessResult(token);
            }else {
                throw new ServiceException("用户名或密码错误");
            }
        }else {
            throw new ServiceException("用户不存在");
        }
    }

    @GetMapping("/getUserInfo")
    public Result getUserInfo() {
        JSONObject info = new JSONObject();
        info.put("roles", "viewer,viewerAndEditor");
        info.put("name", "lurongze");
        info.put("avatar", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2436331379,3968394271&fm=27&gp=0.jpg");
        info.put("introduction", "123");
        return ResultGenerator.genSuccessResult(info);
    }
}
