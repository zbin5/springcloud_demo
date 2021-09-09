package com.zb.springcloud.provider1.controller;

import com.alibaba.fastjson.JSON;
import com.zb.springcloud.common.utils.entity.ResponseData;
import com.zb.springcloud.provider1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("mine")
public class MineController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getUserInfo(Integer userId){
        return JSON.toJSONString(new ResponseData(userInfoService.getInfoByUserId(userId),200,"success"));
    }
}
