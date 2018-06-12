package com.lrz.controller.mp;

import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.alibaba.fastjson.JSONObject;
import com.lrz.core.Result;
import com.lrz.core.ResultGenerator;
import com.lrz.model.OpenUser;
import com.lrz.wechat.MiniService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/mp/index")
public class MpIndexController extends MpBaseController{

    @Resource
    MiniService miniService;

    /**
     * code登录获取微信sessionKey
     * @param code
     * @return
     */
    @GetMapping("/login")
    public Result login(String code) {
        String AppId = this.AppId;
        String AppSecret = this.AppSecret;
        String  session_key = miniService.jsCode2SessionInfo(code, AppId, AppSecret);
        return ResultGenerator.genSuccessResult(session_key);
    }

    /**
     * 获取用户微信信息
     * @param encryptedData
     * @param ivStr
     * @return
     */
    @PostMapping("/getUserInfo")
    public Result getUserInfo(String encryptedData, String ivStr) {
        OpenUser openUser = miniService.getOpenUserBySession(this.sessionKey);
        System.out.println(openUser.toString());
        WxMaUserInfo wxMaUserInfo = miniService.getUserInfo(openUser.getWxSession(), encryptedData, ivStr);
        return ResultGenerator.genSuccessResult(wxMaUserInfo);
    }

    /**
     * 测试获取accessToken
     * @return
     */
    @GetMapping("/getAccessToken")
    public Result getAccessToken() {
        String accessToken = miniService.getAccessToken(this.AppId, this.AppSecret);
        return ResultGenerator.genSuccessResult(accessToken);
    }

    /**
     * 测试获取微信运动的数据
     * @param encryptedData
     * @param ivStr
     * @return
     */
    @PostMapping("/getRunData")
    public Result getRunData(String encryptedData, String ivStr) {
        OpenUser openUser = miniService.getOpenUserBySession(this.sessionKey);
        JSONObject data = miniService.getRunData(openUser.getWxSession(), encryptedData, ivStr);
        return ResultGenerator.genSuccessResult(data);
    }
}
