package com.lrz.wechat;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.google.common.base.Joiner;
import com.google.gson.JsonObject;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by gz000172 on 2018/6/7.
 */
@Service
public class MiniService extends BaseService{

    private String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

    public WxMaJscode2SessionResult jsCode2SessionInfo(String jsCode, String AppId, String secret){
        Map<String, String> params = new HashMap<>(8);
        params.put("appid", AppId);
        params.put("secret", secret);
        params.put("js_code", jsCode);
        params.put("grant_type", "authorization_code");
        String result = HttpGet(JSCODE_TO_SESSION_URL, params);
        return WxMaJscode2SessionResult.fromJson(result);
    }

    public String testPost() {
        JsonObject params = new JsonObject();
        params.addProperty("name", "lurongze");
        params.addProperty("key", "my-key");
        return HttpPost("http://127.0.0.1:7092/html/post", params);
    }

}