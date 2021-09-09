package com.zb.springcloud.provider1.service.Impl;

import com.zb.springcloud.provider1.mapper.UserInfoMapper;
import com.zb.springcloud.provider1.model.UserInfo;
import com.zb.springcloud.provider1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getInfoByUserId(Integer userId) {
        return userInfoMapper.getInfoByUserId(userId);
    }
}
