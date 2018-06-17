package com.lrz.controller.mp;

import com.lrz.core.ServiceException;
import com.lrz.model.OpenUser;
import com.lrz.service.OpenUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class MpBaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    // 小程序sessionKey
    protected String sessionKey;
    protected String AppId;
    protected String AppSecret;
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    OpenUserService openUserService;

    /**
     * 每个方法之前执行的方法
     */
    @ModelAttribute
    void beforeAction() {
        // 获取用户的sessionKey，这里的key值是系统根据微信接口返回加密过的key值，要获取微信的sessionKey，调用miniService.findOpenUserBySession
        this.sessionKey = httpServletRequest.getHeader("authorization");
        // 获取appID，再根据appID获取app secret
        this.AppId = httpServletRequest.getHeader("appid");
        this.AppSecret = "42c52740e810efbf5ce86e2356cba231";
        this.logger.info("this.sessionKey:" + this.sessionKey + "\n this.AppId:" + this.AppId + "\n this.AppSecret:" + this.AppSecret);
    }

    /**
     * 根据用户的session值查找到相应的open-user 记录获取open-id
     * @param authorization 用户的session 值
     * @return 用户的openId 数据库记录
     */
    OpenUser getOpenUser (String authorization) {
        // 查找是否存在对应的登录记录或者说登录失败了, 每个post 请求都回请求一下的
        OpenUser openUser = openUserService.findBy("sessionKey", authorization);
        if (openUser == null) {
            throw new ServiceException("sessionKey失效，请重新登录");
        }
        return openUser;
    }

}
