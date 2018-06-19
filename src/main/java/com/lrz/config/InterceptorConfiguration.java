package com.lrz.config;

import com.lrz.config.interceptors.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * Created by gz000172 on 2018/4/5.
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    // 这里的是为了thymeleaf 引入静态文件的
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };
    /**
     * 这里的是为了thymeleaf 引入静态文件的-- 拦截器拦截了静态资源的请求
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // webjars 引入才需要
        /*if (!registry.hasMappingForPattern("/webjars*//**")) {
         registry.addResourceHandler("/webjars*//**").addResourceLocations(
         "classpath:/META-INF/resources/webjars/");
         }*/
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }

    }
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor()).excludePathPatterns(Arrays.asList("/js/**", "/images/**"));
    }
}
