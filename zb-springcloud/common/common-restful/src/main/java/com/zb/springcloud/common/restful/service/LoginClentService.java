package com.zb.springcloud.common.restful.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "register")
public interface LoginClentService {
    @PostMapping(path = "/oauth/token")
    Map<String, Object> postAccessToken(@RequestParam Map<String, String> parameters);
}
