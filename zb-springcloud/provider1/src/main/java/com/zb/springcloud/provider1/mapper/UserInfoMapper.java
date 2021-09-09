package com.zb.springcloud.provider1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.springcloud.provider1.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("SELECT u.user_id,u.user_name,u.employee_id,u.description as \"USER_NAME_N\",e.unit_id,e.unit_name,\n" +
            "        e.position_type,e.company_short_name,e.company_id\n" +
            "        FROM sys_user u, exp_employee_assigns_v e\n" +
            "        WHERE u.employee_id = e.employee_id AND e.enabled_flag = 'Y'\n" +
            "        AND e.primary_position_flag = 'Y' AND u.user_id=#{userId}")
    UserInfo getInfoByUserId(Integer userId);
}
