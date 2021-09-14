package com.zb.springcloud.provider2.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserInfo {
    @TableId
    @TableField("USER_ID")
    private Integer userId;
    @TableField("USER_NAME")
    private String userName;
    @TableField("USER_NAME_N")
    private String userNameN;
    @TableField("UNIT_NAME")
    private String unitName;
    @TableField("COMPANY_SHORT_NAME")
    private String companyShortName;
    @TableField("COMPANY_ID")
    private Integer companyId;
    @TableField("UNIT_ID")
    private Integer unitId;
    @TableField("EMPLOYEE_ID")
    private String employeeId;
    @TableField("POSITION_TYPE")
    private String positionType;
}
