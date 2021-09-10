package com.zb.springcloud.provider1.controller;

import com.alibaba.fastjson.JSON;
import com.zb.springcloud.common.utils.entity.ResponseData;
import com.zb.springcloud.provider1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/findOrder")
    public String findOrder(){
        stringRedisTemplate.opsForValue().set("test",JSON.toJSONString(orderService.list()));
        return JSON.toJSONString(new ResponseData(orderService.list(),200,"success"));
    }
}
