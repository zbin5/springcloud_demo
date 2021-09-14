package com.zb.springcloud.mq.consumer.listener;

import com.zb.springcloud.mq.consumer.service.MqInputMessageSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@Slf4j
@EnableBinding(MqInputMessageSource.class)
public class MessageConsumer {
    @StreamListener(MqInputMessageSource.TEST_IN_PUT)
    public void readMq(Message<String> message) {
        log.info("消息消费完成：" + message.getPayload());
    }
}
