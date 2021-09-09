package com.zb.springcloud.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "register")
public interface LoginOauthService {
    @PostMapping(path = "/auth/oauth/token")
    Map<String, Object> postAccessToken(@RequestParam Map<String, String> parameters);
}
