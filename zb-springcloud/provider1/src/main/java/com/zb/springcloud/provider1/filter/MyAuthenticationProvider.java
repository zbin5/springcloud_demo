//package com.zb.springcloud.provider1.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
//
//    //前面我们自己实现的读取用户信息的实现类
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    //全局加密方式
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    //对表单传入的用户信息和线程上下文中的用户进行比对判断是否是正确的用户
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails,
//                                                  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
//            throws AuthenticationException {
//        //数据库中的密码
//        String authPassword = userDetails.getPassword();
//        //上下文中的密码
//        String tokenPassword = (String) usernamePasswordAuthenticationToken.getCredentials();
//        boolean isPass = passwordEncoder.matches(tokenPassword, authPassword);
//        if (isPass) {
//            return;
//        }
//        throw new AuthenticationServiceException("password.wrong");
//    }
//
//    //根据表单中传入的用户名从数据库中获取用户信息
//    @Override
//    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//        UserDetails user = userDetailsService.loadUserByUsername(username);
//        if (user == null) {
//            throw new AuthenticationServiceException("未找到用户");
//        }
//        return user;
//    }
//}
