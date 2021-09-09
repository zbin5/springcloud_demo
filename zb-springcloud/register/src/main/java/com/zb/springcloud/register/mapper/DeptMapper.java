package com.zb.springcloud.register.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.springcloud.register.entity.DeptData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date: Create in 11:06 2021/8/26
 * @UpdateBy:
 */
@Mapper
public interface DeptMapper extends BaseMapper<DeptData> {
    @Select(" SELECT * from sys_dept where dept_id= #{deptId}")
    List<DeptData> selectDeptDataByUserId(@Param("deptId") Integer deptId);
}
