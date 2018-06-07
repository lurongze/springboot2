package com.lrz.controller.mp;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.wechat.MiniService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/mp/index")
public class MpIndexController extends MpBaseController{

    @Resource
    MiniService miniService;

    @GetMapping("/login")
    public Result login(String code) {
        String AppId = "wxe22a8310f6aadeff";
        String AppSecret = "42c52740e810efbf5ce86e2356cba231";
        WxMaJscode2SessionResult wxMaJscode2SessionResult = miniService.jsCode2SessionInfo(code, AppId, AppSecret);
        this.logger.info(wxMaJscode2SessionResult.toString());
        return ResultGenerator.genSuccessResult(wxMaJscode2SessionResult.getSessionKey());
    }
}
