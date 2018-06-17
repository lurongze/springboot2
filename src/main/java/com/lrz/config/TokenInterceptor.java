package com.lrz.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

    // 这里的是为了thymeleaf 引入静态文件的
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };


    /**
     * 这里的是为了thymeleaf 引入静态文件的
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }

    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String URI = request.getRequestURI();
            logger.info("进入拦截器");
            if(URI.startsWith("/mp")){ // 小程序的API
                String method = request.getMethod().toUpperCase();
                logger.info("请求的method:" + method);
                // GET请求不验证，要验证的都使用post，put等请求
                if("GET".equals(method) || "OPTIONS".equals(method)) {
                    return true;
                }else{
                    String authorization = request.getHeader("authorization");
                    if(StringUtils.isEmpty(authorization)){
                        throw new RuntimeException("post请求必须要有authorization的header值");
                    }else {
                        if (authorization.length() < 10) {
                            throw new RuntimeException("authorization长度错误");
                        }
                    }
                }
            }
            return true;
            }
        });
    }
}
