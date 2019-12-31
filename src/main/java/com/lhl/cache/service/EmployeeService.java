package com.lhl.cache.service;

import com.lhl.cache.bean.Employee;
import com.lhl.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试就不写service接口，正常是要写的
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmpById(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpByID(id);
        return emp;
    }
}
