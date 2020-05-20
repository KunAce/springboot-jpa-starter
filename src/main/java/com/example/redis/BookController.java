package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("/test1")
    public void test1(){
        ValueOperations<String,String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name","Javabook");
        String name = ops1.get("name");
        System.out.println(name);
        ValueOperations ops2 = redisTemplate.opsForValue();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("PythonBook");
        b1.setAuthor("Bryan");
        ops2.set("b1",b1);
        Book book = (Book) ops2.get("b1");
        System.out.println(book);
    }
}
