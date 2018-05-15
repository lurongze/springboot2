package com.lrz.config;

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
                logger.info("request method : " + request.getMethod());
                logger.info("进来了,TOKEN : " + request.getHeader("authorization"));
                logger.info("url : " + request.getRequestURI());
                return true;
            }
        });
    }
}
