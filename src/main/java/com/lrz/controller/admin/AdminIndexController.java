package com.lrz.controller.admin;

import com.lrz.core.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gz000172 on 2018/6/5.
 */
@RestController
@RequestMapping("/admin/index")
public class AdminIndexController extends AdminBaseController{
    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "error") String type) {
        if("error".equals(type)) {
            throw new ServiceException("type类型错误");
        }
        return "admin-index";
    }
}
