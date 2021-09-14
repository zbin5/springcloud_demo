package com.zb.springcloud.mq.consumer;

import com.zb.springcloud.mq.consumer.service.MqInputMessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(MqInputMessageSource.class)
public class MqConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqConsumerApplication.class);
    }
}
