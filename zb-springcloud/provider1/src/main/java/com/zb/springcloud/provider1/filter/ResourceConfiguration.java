package com.zb.springcloud.provider1.filter;

import com.zb.springcloud.provider1.filter.handler.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@Slf4j
public class ResourceConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.info("##### 使用默认的配置，表示对所有资源都需要授权认证，即授权通过后可以访问所有资源 #####");
        super.configure(http);
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("##### 设置资源id #####");
        resources.resourceId("res1");
    }
}
