package com.zb.springcloud.consumer1.feignFallbackFactory;

import com.zb.springcloud.consumer1.service.MineService;
import org.springframework.stereotype.Component;

@Component
public class MineServiceFallbackFactory implements MineService {
    @Override
    public String getUserInfo(Integer userId) {
        return "发生熔断!!! 异常信息: ";
    }
}
