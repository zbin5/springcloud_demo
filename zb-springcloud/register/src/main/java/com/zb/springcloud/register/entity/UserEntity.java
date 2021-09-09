package com.zb.springcloud.register.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:
 * @Description:
 * @Date: Create in 11:12 2021/8/26
 * @UpdateBy:
 */
@TableName("t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @TableId
    private Integer id;

    private String username;

    private String password;

    private String fullname;
}