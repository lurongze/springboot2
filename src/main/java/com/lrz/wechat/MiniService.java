package com.lrz.wechat;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;
import com.lrz.core.HttpService;
import com.lrz.core.HttpResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by lrz on 2018/6/7.
 * 微信小程序的接口
 */
@Service
public class MiniService extends BaseService{

    @Resource
    private HttpService httpAPIService;

    private String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

    public WxMaJscode2SessionResult jsCode2SessionInfo(String jsCode, String AppId, String secret){
        try{
            Map<String, Object> params = new HashMap<>();
            params.put("appid", AppId);
            params.put("secret", secret);
            params.put("js_code", jsCode);
            params.put("grant_type", "authorization_code");
            String result = httpAPIService.doGet(JSCODE_TO_SESSION_URL, params);
            return WxMaJscode2SessionResult.fromJson(result);
        } catch (Exception e) {
            return null;
        }
    }

    public WxMaUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
        return WxMaUserInfo.fromJson(WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr));
    }

    public String testPost() {

        try{
            Map<String, Object> params = new HashMap<>();
            params.put("name", "lurongze123");
            params.put("key", "my-key321");
            HttpResult res =  httpAPIService.doPost("http://127.0.0.1:7092/html/post", params);
            return res.getBody();
        } catch (Exception e) {
            return null;
        }

    }

    public String testGet() {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("name", "lurongze");
            params.put("key", "my-key");
            return httpAPIService.doGet("http://127.0.0.1:7092/html/post", params);
        } catch (Exception e) {
            return null;
        }
    }

}
