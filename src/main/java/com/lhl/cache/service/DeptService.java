package com.lhl.cache.service;

import com.lhl.cache.bean.Department;
import com.lhl.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisCacheManager deptCacheManager;

    /**
     *  缓存的数据能存入redis；
     *  第二次从缓存中查询就不能反序列化回来；
     *  因为存的是dept的json数据;CacheManager默认使用RedisTemplate<Object, Employee>操作Redis
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门："+id);
//        Department department = departmentMapper.getDeptById(id);
//        return department;
//    }

    // 使用缓存管理器得到缓存，进行api调用，这种就可以不使用注解 @Cacheable

    /**
     * 这种是编码方式：
     *   假如开发中如果我们得到某个数据，或者更新数据及删除某个数据
     *   我们可以使用编码方式(当然也可以使用注解方式)，来改变缓存数据
     *   首先我们的获取你所需要的缓存，根据缓存名获取
     * @param id
     * @return
     */
      public Department getDeptById(Integer id){
          System.out.println("查询部门"+id);
          Department department = departmentMapper.getDeptById(id);

          //获取某个缓存
          Cache dept = deptCacheManager.getCache("dept");
          //往缓存中放入数据 设置key为“dept:1”
          dept.put("dept:1",department);

          return department;
    }

}
