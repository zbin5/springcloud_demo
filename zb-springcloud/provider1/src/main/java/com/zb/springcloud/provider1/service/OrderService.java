package com.zb.springcloud.provider1.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zb.springcloud.provider1.mapper.OrderMapper;
import com.zb.springcloud.provider1.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order>{
//    public UserEntity getUserByUsername(String username) {
//        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
//        wrapper.eq("username", username);
//        return baseMapper.selectOne(wrapper);
//    }
}