package com.lrz.wechat;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;
import com.alibaba.fastjson.JSONObject;
import com.lrz.core.HttpService;
import com.lrz.core.HttpResult;
import com.lrz.core.ServiceException;
import com.lrz.model.OpenUser;
import com.lrz.service.OpenUserService;
import com.lrz.utils.HashCrypt;
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
    private HttpService httpService;
    @Resource
    private OpenUserService openUserService;

    private String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

    /**
     * 根据code，获取微信登录的sessionKey
     * @param jsCode
     * @param AppId
     * @param secret
     * @return 根据微信接口返回的session生成的md5加密sessionKey
     */
    public String jsCode2SessionInfo(String jsCode, String AppId, String secret){
        try{
            Map<String, Object> params = new HashMap<>();
            params.put("appid", AppId);
            params.put("secret", secret);
            params.put("js_code", jsCode);
            params.put("grant_type", "authorization_code");
            String result = httpService.doGet(JSCODE_TO_SESSION_URL, params);
            WxMaJscode2SessionResult wxMaJscode2SessionResult = WxMaJscode2SessionResult.fromJson(result);
            OpenUser openUser = openUserService.findBy("openid", wxMaJscode2SessionResult.getOpenid());
            String wx_session = wxMaJscode2SessionResult.getSessionKey(); // 微信的sessionKey
            String session_key = HashCrypt.string2MD5(wx_session + "@+@" + AppId); // 自定义的session
            if (openUser !=null && openUser.getOpenid().length() > 0) {
                openUser.setWxSession(wx_session);
                openUser.setSessionKey(session_key);
                openUserService.save(openUser);
            } else {
                OpenUser newOpenUser = new OpenUser();
                newOpenUser.setWxSession(wx_session);
                newOpenUser.setSessionKey(session_key);
                newOpenUser.setOpenid(wxMaJscode2SessionResult.getOpenid());
                newOpenUser.setAppid(AppId);
                newOpenUser.setUnionid(wxMaJscode2SessionResult.getUnionid());
                newOpenUser.setInfo("");
                openUserService.save(newOpenUser);
            }
            return session_key;
        } catch (Exception e) {
            throw new ServiceException("获取openid失败"+e.getMessage());
        }
    }

    /**
     * 获取微信用户的详细信息资料
     * @param sessionKey
     * @param encryptedData
     * @param ivStr
     * @return
     */
    public WxMaUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
        return WxMaUserInfo.fromJson(WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr));
    }

    public JSONObject getRunData(String sessionKey, String encryptedData, String ivStr) {
        String data = WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr);
        return JSONObject.parseObject(data);
    }

    public String testPost() {
        try{
            Map<String, Object> params = new HashMap<>();
            params.put("name", "lurongze123");
            params.put("key", "my-key321");
            HttpResult res =  httpService.doPost("http://127.0.0.1:7092/html/post", params);
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
            return httpService.doGet("http://127.0.0.1:7092/html/post", params);
        } catch (Exception e) {
            return null;
        }
    }

}
