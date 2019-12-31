package com.lhl.cache.controller;

import com.lhl.cache.bean.Employee;
import com.lhl.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id")Integer id){
        Employee emp = employeeService.getEmpById(id);
        return emp;
    }
}
