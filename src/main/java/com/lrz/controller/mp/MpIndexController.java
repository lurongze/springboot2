package com.lrz.controller.mp;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.wechat.MiniService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/mp/index")
public class MpIndexController extends MpBaseController{

    @Resource
    MiniService miniService;

    @GetMapping("/login")
    public Result login(String code) {
        String AppId = this.AppId;
        String AppSecret = this.AppSecret;
        WxMaJscode2SessionResult wxMaJscode2SessionResult = miniService.jsCode2SessionInfo(code, AppId, AppSecret);
        this.logger.info(wxMaJscode2SessionResult.toString());
        return ResultGenerator.genSuccessResult(wxMaJscode2SessionResult.getSessionKey());
    }

    @PostMapping("/getUserInfo")
    public Result getUserInfo(String encryptedData, String ivStr) {
        WxMaUserInfo wxMaUserInfo = miniService.getUserInfo(this.sessionKey, encryptedData, ivStr);
        return ResultGenerator.genSuccessResult(wxMaUserInfo);
    }
}
