package com.lrz.wechat;

import com.lrz.core.RedisService;
import com.lrz.core.ServiceException;
import com.lrz.model.OpenUser;
import com.lrz.service.OpenUserService;
import com.lrz.utils.HttpResult;
import com.lrz.utils.HttpUtil;
import me.chanjar.weixin.common.bean.WxAccessToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gz000172 on 2018/6/7.
 */
public class BaseService{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private Lock accessTokenLock = new ReentrantLock();
    private String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    @Resource
    private RedisService redisService;
    @Resource
    private OpenUserService openUserService;

    /**
     * 根据用户的session值查找到相应的open-user 记录获取open-id
     * @param authorization 用户的session 值
     * @return 用户的openId 数据库记录
     */
    public OpenUser getOpenUserBySession(String session) {
        OpenUser openUser = openUserService.findBy("sessionKey", session);
        if (openUser == null) {
            throw new ServiceException("sessionKey失效，请重新登录");
        }
        return openUser;
    }

    /**
     * 全局获取accesstoken
     * @param AppId appId 的值
     * @param AppSecret appSecret 的值
     * @return
     */
    public String getAccessToken(String AppId, String AppSecret) {
        logger.info("appid:" + AppId + ",appsecret:" + AppSecret);
        Lock lock = accessTokenLock; // 这里锁住，应该是防止高并发的时候access token 出错
        try {
            lock.lock();
            String accessKey = "AccessToken@@" + AppId + "@@" + StringUtils.substring(AppId, 2, 6);
            String accessToken = redisService.getStr(accessKey);
            if (StringUtils.isEmpty(accessToken)) {

                try{
                    Map<String, String> params = new HashMap<>(3);
                    params.put("grant_type", "client_credential");
                    params.put("appid", AppId);
                    params.put("secret", AppSecret);
                    HttpResult response = HttpUtil.httpDoGet(GET_ACCESS_TOKEN_URL, null, params);
                    System.out.println(response.toString());
                    String res = response.getBody();
                    WxAccessToken wxAccessToken = WxAccessToken.fromJson(res);
                    logger.info(wxAccessToken.toString());
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
