package com.zb.springcloud.provider1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.zb.springcloud.provider1.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class Provider1Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider1Application.class, args);
    }

}