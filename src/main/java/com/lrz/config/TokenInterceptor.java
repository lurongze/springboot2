package com.lrz.config;

import com.sun.xml.internal.fastinfoset.stax.events.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gz000172 on 2018/4/5.
 */
@Configuration
public class TokenInterceptor implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String URI = request.getRequestURI();
            logger.info("进入拦截器");
            if(URI.startsWith("/")){ // 小程序的API
                String method = request.getMethod().toUpperCase();
                logger.info("请求的method:" + method);
                if("GET".equals(method) || "OPTIONS".equals(method)) { // GET请求不验证，要验证的都使用post，put等请求
                    return true;
                }else{
                    String authorization = request.getHeader("authorization");
                    if(Util.isEmptyString(authorization)){
                        throw new RuntimeException("post请求必须要有authorization的header值");
                    }else {
                        if (authorization.length() < 10) {
                            throw new RuntimeException("authorization错误");
                        }
                    }
                }
            }
            return true;
            }
        });
    }
}
