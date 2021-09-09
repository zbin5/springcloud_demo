package com.zb.springcloud.register.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.springcloud.register.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:
 * @Description:
 * @Date: Create in 11:11 2021/8/26
 * @UpdateBy:
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}

