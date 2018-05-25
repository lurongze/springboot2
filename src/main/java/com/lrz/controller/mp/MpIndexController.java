package com.lrz.controller.mp;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.lrz.controller.BaseController;
import com.lrz.model.OpenUser;
import com.lrz.service.MiniappService;
import com.lrz.utils.JsonUtils;
import com.lrz.utils.Response;
import com.lrz.utils.Result;
import com.lrz.utils.Utils;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by gz000172 on 2018/5/14.
 */
@RestController
@RequestMapping("/mp")
public class MpIndexController extends BaseController {
    @Autowired
    private WxMaService wxService;
    @Autowired
    private MiniappService miniappService;
    @GetMapping("/login")
    public Result login(HttpServletRequest request) {
        String code = request.getHeader("x-login-code");
        if(StringUtils.isBlank(code)) {
            return Response.fail("empty jscode");
        }
        try{
            WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
            String sessionKey = miniappService.addOpenId(session);
            return Response.success(sessionKey);
        }catch (WxErrorException e){
            return Response.fail(e.toString());
        }
    }

    @PostMapping("/user-info")
    public Result userInfo(String iv, String enData, HttpServletRequest request) {
        String session = getSession(request);
        OpenUser openUser = miniappService.getOpenUserBySession(session);
        WxMaUserInfo wxUserInfo = this.wxService.getUserService().getUserInfo(openUser.getWxSession(), enData, iv);
        logger.info(wxUserInfo.toString());
        return Response.success(JsonUtils.toJson(wxUserInfo));
    }
}

