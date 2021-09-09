package com.zb.springcloud.login.server.controller;

import com.alibaba.fastjson.JSON;
import com.zb.springcloud.common.utils.entity.ResponseData;
import com.zb.springcloud.login.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String loginIn(String username,String password){
        return JSON.toJSONString(new ResponseData(loginService.login(username,password),200,"success"));
    }

}
