package com.zb.springcloud.login.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.zb.springcloud.common.restful.service","com.zb.springcloud.login.server.service"})
//@ComponentScan(basePackages = {"com.zb.springcloud.common.restful.service","com.zb.springcloud.login.server.service"})
public class LoginServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginServerApplication.class, args);
    }
}
