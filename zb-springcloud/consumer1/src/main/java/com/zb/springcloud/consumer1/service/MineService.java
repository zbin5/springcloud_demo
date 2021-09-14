package com.zb.springcloud.consumer1.service;

import com.zb.springcloud.consumer1.feignFallbackFactory.MineServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider",fallback = MineServiceFallbackFactory.class)
public interface MineService {
    @RequestMapping(value = "/mine/getUserInfo", method = RequestMethod.POST)
    String getUserInfo(@RequestParam Integer userId);
}
