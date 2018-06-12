package com.lrz.wechat;

import com.lrz.core.HttpService;
import com.lrz.core.RedisService;
import com.lrz.core.ServiceException;
import com.lrz.model.OpenUser;
import com.lrz.service.OpenUserService;
import me.chanjar.weixin.common.bean.WxAccessToken;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gz000172 on 2018/6/7.
 */
public class BaseService{
    private Lock accessTokenLock = new ReentrantLock();
    @Resource
    private RedisService redisService;
    @Resource
    private HttpService httpService;
    @Resource
    private OpenUserService openUserService;
    public OpenUser getOpenUserBySession(String session) {
        return openUserService.findBy("sessionKey", session);
    }

    /**
     * 全局获取accesstoken
     * @param AppId
     * @param AppSecret
     * @return
     */
    public String getAccessToken(String AppId, String AppSecret) {
        Lock lock = accessTokenLock; // 这里锁住，应该是防止高并发的时候access token 出错
        try {
            lock.lock();
            String accessKey = "AccessToken@@" + AppId + "@@" + StringUtils.substring(AppSecret, 0, 4);
            String accessToken = redisService.getStr(accessKey);
            if (StringUtils.isEmpty(accessToken)) {
                String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + AppId + "&secret=" + AppSecret;
                try{
                    String res = httpService.doGet(GET_ACCESS_TOKEN_URL);
                    WxAccessToken wxAccessToken = WxAccessToken.fromJson(res);
                    System.out.println(wxAccessToken.toString());
                    int expiresIn = wxAccessToken.getExpiresIn()-200;
                    redisService.setStr(accessKey, wxAccessToken.getAccessToken(), expiresIn);
                    return wxAccessToken.getAccessToken();
                } catch (Exception e) {
                    throw new ServiceException("accessToken 获取失败");
                }
            } else {
                return accessToken;
            }
        } finally {
            lock.unlock();
        }
    }
}
