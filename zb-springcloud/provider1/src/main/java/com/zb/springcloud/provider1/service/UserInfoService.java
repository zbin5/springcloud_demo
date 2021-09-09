package com.zb.springcloud.provider1.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zb.springcloud.provider1.mapper.UserInfoMapper;
import com.zb.springcloud.provider1.model.UserInfo;

public interface UserInfoService{
    UserInfo getInfoByUserId(Integer userId);
}
