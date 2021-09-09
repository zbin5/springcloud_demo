//package com.zb.springcloud.common.security.filter;
//
//import com.zb.springcloud.common.security.handler.FailureHandler;
//import com.zb.springcloud.common.security.handler.LogoutHandler;
//import com.zb.springcloud.common.security.handler.SuccessHandler;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Slf4j
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private SuccessHandler successHandler;
//
//    @Autowired
//    private FailureHandler failureHandler;
//
//    @Autowired
//    private LogoutHandler logoutHandler;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        log.info("##### WebSecurityConfig #####");
//        http.csrf().disable().formLogin()
//                .loginProcessingUrl("/mine").permitAll()
//                .successHandler(successHandler).permitAll()
//                .failureHandler(failureHandler).permitAll().and()
//                .logout().logoutSuccessHandler(logoutHandler).and()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll();
//    }
//}