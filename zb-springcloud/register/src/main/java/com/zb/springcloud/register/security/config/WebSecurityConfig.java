package com.zb.springcloud.register.security.config;

import com.zb.springcloud.register.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author:
 * @Description:
 * @Date: Create in 11:00 2021/8/26
 * @UpdateBy:
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SuccessHandler successHandler;

    @Autowired
    private FailureHandler failureHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin()
                .loginProcessingUrl("/login").permitAll()
                .successHandler(successHandler).permitAll()
                .failureHandler(failureHandler).permitAll().and()
                .logout().logoutSuccessHandler(logoutHandler).and()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}
