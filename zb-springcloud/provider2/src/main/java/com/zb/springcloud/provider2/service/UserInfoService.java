package com.zb.springcloud.provider2.service;

import com.zb.springcloud.provider2.model.UserInfo;

public interface UserInfoService{
    UserInfo getInfoByUserId(Integer userId);
}
