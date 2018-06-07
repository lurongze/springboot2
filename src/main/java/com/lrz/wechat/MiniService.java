package com.lrz.wechat;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.google.common.base.Joiner;
import me.chanjar.weixin.common.exception.WxErrorException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gz000172 on 2018/6/7.
 */
public class MiniService extends BaseService{

    private String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

    public WxMaJscode2SessionResult jsCode2SessionInfo(String jsCode, String AppId, String secret) throws WxErrorException {

        Map<String, String> params = new HashMap<>(8);
        params.put("appid", AppId);
        params.put("secret", secret);
        params.put("js_code", jsCode);
        params.put("grant_type", "authorization_code");

        String result = get(JSCODE_TO_SESSION_URL, Joiner.on("&").withKeyValueSeparator("=").join(params));
        return WxMaJscode2SessionResult.fromJson(result);
    }

}
