//package com.zb.springcloud.provider1.filter;
//
//import com.zb.springcloud.register.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private MyAuthenticationProvider authenticationProvider;
//
//    /**
//     * 注入用户信息服务
//     * @return 用户信息服务对象
//     */
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        return (UserDetailsService) new UserService();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS,"/oauth/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf()
//                .disable();
//    }
//}
