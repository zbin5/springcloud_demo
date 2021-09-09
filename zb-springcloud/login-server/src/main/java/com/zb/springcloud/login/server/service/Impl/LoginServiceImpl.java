package com.zb.springcloud.login.server.service.Impl;

import com.zb.springcloud.common.restful.service.LoginClentService;
import com.zb.springcloud.login.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginClentService loginClentService;

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, String> map=new HashMap<>();
        map.put("client_id","c1");
        map.put("client_secret","secret");
        map.put("grant_type","password");
        map.put("username",username);
        map.put("password",password);
        return loginClentService.postAccessToken(map);
    }
}
