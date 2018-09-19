package com.lrz.controller.mp;

import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.utils.HttpResult;
import com.lrz.utils.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gz000172 on 2018/9/19.
 */
@RestController
@RequestMapping("/mp/spider")
public class SpiderController extends MpBaseController{

    @PostMapping("/detail")
    public Result detail(@RequestParam(defaultValue = "0") String url) {
        try {
            HttpResult res = HttpUtil.httpDoGet(url, null, null);
            System.out.println(res);
            return ResultGenerator.genSuccessResult(res);
        } catch (Exception e) {
            return ResultGenerator.genFailResult(e.toString());
        }
    }

}
