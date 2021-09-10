package com.zb.springcloud.provider1.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class SecurityConfig implements WebMvcConfigurer {
    private TokenInterceptor tokenInterceptor;
    //构造方法
    public SecurityConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        log.info("##### WebMvcConfigurer 配置 token 拦截器 #####");
        registry.addInterceptor(tokenInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
