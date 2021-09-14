package com.zb.springcloud.consumer1.controller;

import com.zb.springcloud.consumer1.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("mine")
@RestController
public class MineController {
    @Autowired
    private MineService mineService;

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getUserInfo(Integer userId){
        return mineService.getUserInfo(userId);
    }
}
