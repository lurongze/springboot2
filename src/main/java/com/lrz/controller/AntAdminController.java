package com.lrz.controller;


import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/ant-admin")
public class AntAdminController {
    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        HashMap<String, String> res = new HashMap<>();
        if (!"lurongze".equals(login.getUsername()) || !"123456".equals(login.getPassword())) {
            return ResultGenerator.genFailResult("账号或密码错误");
        }
        res.put("name", login.getUsername());
        res.put("token", UUID.randomUUID().toString());
        return ResultGenerator.genSuccessResult(res);
    }
}

class Login {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
