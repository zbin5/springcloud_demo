package com.zb.springcloud.provider2;

import com.zb.springcloud.provider2.rabbit.service.MqMessageSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@MapperScan("com.zb.springcloud.provider2.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(MqMessageSource.class)
public class Provider2Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider2Application.class, args);
    }

}