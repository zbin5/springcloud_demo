package com.zb.springcloud.provider2.controller;

import com.alibaba.fastjson.JSON;
import com.zb.springcloud.common.utils.entity.ResponseData;
import com.zb.springcloud.common.utils.redis.RedisLockUtil;
import com.zb.springcloud.provider2.rabbit.service.MqMessageProducer;
import com.zb.springcloud.provider2.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mine")
public class MineController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MqMessageProducer mqMessageProducer;


    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getUserInfo(Integer userId){
        mqMessageProducer.sendMsg("发送消息：userId="+userId.toString());
        if(!RedisLockUtil.setLock(userId.toString(),redisTemplate))
            return JSON.toJSONString(new ResponseData("数据被锁住了！"));
        return JSON.toJSONString(new ResponseData(userInfoService.getInfoByUserId(userId),200,"success"));
    }
}
