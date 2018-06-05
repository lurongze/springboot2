package com.lrz.controller.mp;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mp/index")
public class MpIndexController extends MpBaseController{

    @GetMapping("/login")
    public Result login(String code) {
        return ResultGenerator.genSuccessResult(code);
    }
}
