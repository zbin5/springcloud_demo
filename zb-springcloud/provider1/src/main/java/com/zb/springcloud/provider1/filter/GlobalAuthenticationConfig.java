//package com.zb.springcloud.provider1.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
//
//@Configuration
//public class GlobalAuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {
//
//    @Autowired
//    private MyAuthenticationProvider authenticationProvider;
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider( authenticationProvider);
//    }
//}
