package com.lrz.config.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lrz.core.ServiceException;
import com.lrz.utils.HelperUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gz000172 on 2018/4/5.
 */
@Configuration
public class TokenInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String URI = request.getRequestURI();
        logger.info("进入拦截器:" + URI);
        if(URI.startsWith("/mp")) { // 小程序的API
            String method = request.getMethod().toUpperCase();
            // GET请求不验证，要验证的都使用post，put等请求
            if("GET".equals(method) || "OPTIONS".equals(method)) {
                return true;
            }else{
                String authorization = request.getHeader("authorization");
                if(StringUtils.isEmpty(authorization)){
                    response.sendError(401);
                    throw new ServiceException("post请求必须要有authorization的header值");
                }else {
                    if (authorization.length() < 10) {
                        response.sendError(401);
                        throw new ServiceException("authorization长度错误");
                    }
                }
            }
        }

        if(URI.startsWith("/admin")) { // 后台登录验证 -- start
            String id = "0";
            // 登录和OPTIONS请求就不验证token了
            if(!"/admin/index/login".equals(URI) && !"OPTIONS".equals(request.getMethod().toUpperCase())) {
                String authorization = request.getHeader("authorization");
                if(StringUtils.isEmpty(authorization)){
                    response.sendError(401);
                    throw new ServiceException("请求必须要有authorization的header值");
                }else {
                    // 开始判断token里面的信息，base64解码后等到内容和加密串。通过再次加密内容和加密串对比
                    String tokenInfo = HelperUtil.Base64Decode(authorization);
                    JSONObject info = JSON.parseObject(tokenInfo);
                    String name = info.getString("name");
                    id = info.getString("id");
                    String sign = info.getString("sign");
                    String loginTime = info.getString("loginTime");
                    String IP = HelperUtil.getIpAddress(request);
                    String encodeSign = HelperUtil.encodePassword( name + "*|*" + id + "*|*" + IP + "*|*" + loginTime);
                    if(!sign.equals(encodeSign)) {
                        response.sendError(401);
                        throw new ServiceException("非法authorization");
                    }else {
                        Integer time = HelperUtil.getTimeStamp();
                        Integer tokenTime = Integer.valueOf(loginTime);
                        if((tokenTime + 3600*2) < time) {
                            response.sendError(401);
                            throw new ServiceException("登录信息已过期，请重新登录");
                        }
                    }
                }
            }
            // 把用户的id 传递过去，少操作一次
            request.setAttribute("userId", id);
        } // 后台登录验证 -- end
        return true;
    }
}
