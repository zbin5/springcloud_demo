package com.zb.springcloud.mq.consumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface MqInputMessageSource {
    String TEST_IN_PUT = "testInPut";

    @Input(TEST_IN_PUT)
    MessageChannel testInPut();
}
