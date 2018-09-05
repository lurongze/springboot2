package com.lrz.controller.mp;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gz000172 on 2018/9/5.
 */
@RestController
@RequestMapping("/mp/product")
public class MpProductController extends MpBaseController{
    @GetMapping("/list")
    public Result list() {
        return ResultGenerator.genSuccessResult();
    }
}
