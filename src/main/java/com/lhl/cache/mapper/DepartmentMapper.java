package com.lhl.cache.mapper;

import com.lhl.cache.bean.Department;
import com.lhl.cache.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    public Department getDeptById(Integer id);
}
