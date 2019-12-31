package com.lhl.cache;

import com.lhl.cache.bean.Employee;
import com.lhl.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
	private EmployeeMapper employeeMapper;

	@Test
	public void contextLoads() {
        Employee emp = employeeMapper.getEmpByID(1);
        System.out.println(emp);
    }

}
