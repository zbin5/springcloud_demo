package com.zb.springcloud.register.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dept")
public class DeptData {
    @TableId
    private Integer deptId;

    private Integer parentId;

    private String deptName;

    private String leader;
}
