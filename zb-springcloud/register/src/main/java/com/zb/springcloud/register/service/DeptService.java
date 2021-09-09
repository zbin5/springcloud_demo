package com.zb.springcloud.register.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zb.springcloud.register.entity.DeptData;
import com.zb.springcloud.register.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date: Create in 11:30 2021/8/26
 * @UpdateBy:
 */
@Service
public class DeptService extends ServiceImpl<DeptMapper, DeptData> {
    public List<DeptData> getPermissionsByUserId(Integer userId){
        return baseMapper.selectDeptDataByUserId(userId);
    }
}
