package com.woniu.permission;

import com.woniu.permission.entity.Role;
import com.woniu.permission.service.IRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class PermissionApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate ;

    @Autowired
    RedisTemplate redisTemplate ;

    @Autowired
    IRoleService roleService ;

    @Test
    void contextLoads() {
    }


    @Test
    void testRedis01(){

        //stringRedisTemplate.opsForValue()
        //stringRedisTemplate.opsForList()
        //stringRedisTemplate.opsForHash() ;
       // stringRedisTemplate.opsForZSet()
        //stringRedisTemplate.opsForSet()

        //stringRedisTemplate.opsForValue().set("username","jack");
        String username = stringRedisTemplate.opsForValue().get("username");
        System.out.println(username);
    }

    @Test
    void testRedis02() {
        Role role = roleService.findRoleByKey(1);

        redisTemplate.opsForValue().set("role01",role);
    }

    @Test
    void testRedisCache01(){


    }

}
