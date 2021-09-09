package com.zb.springcloud.login.server.service;

import java.util.Map;

public interface LoginService {
    Map<String, Object> login(String username, String password);
}
