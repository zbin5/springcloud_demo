package com.zb.springcloud.register.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zb.springcloud.register.entity.UserEntity;
import com.zb.springcloud.register.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @Author:
 * @Description:
 * @Date: Create in 11:30 2021/8/26
 * @UpdateBy:
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {
    public UserEntity getUserByUsername(String username) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }
}
