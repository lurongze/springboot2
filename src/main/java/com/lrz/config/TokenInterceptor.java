package com.lrz.config;

import com.lrz.service.MiniappService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    MiniappService miniappService;
    private final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String URI = request.getRequestURI();
            if(URI.startsWith("/mp")){ // 小程序的API
                if(request.getMethod().toUpperCase().equals("GET")) { // GET请求不验证，要验证的都使用post，put等请求
                    return true;
                }else{
                    if(!miniappService.checkSession(request.getHeader("authorization"))){
                        throw new RuntimeException("authorization miss");
                    }
                }
            }
            return true;
            }
        });
    }
}
