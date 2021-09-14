package com.zb.springcloud.provider2.rabbit.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface  MqMessageSource {
    String TEST_OUT_PUT = "testOutPut";
    @Output(TEST_OUT_PUT)
    MessageChannel testOutPut();
}
