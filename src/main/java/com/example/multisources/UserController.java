package com.example.multisources;

import com.example.multisources.dao1.UserDao1;
import com.example.multisources.dao2.UserDao2;
import com.example.multisources.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserDao1 userDao1;
    @Autowired
    UserDao2 userDao2;
    @GetMapping("/test1")
    public void test1() {
        User u1 = new User();
        u1.setAge(55);
        u1.setName("JavaUser");
        u1.setGender("Male");
        userDao1.save(u1);

        User u2 = new User();
        u2.setAge(80);
        u2.setName("PythonUser");
        u2.setGender("Male");
        userDao2.save(u2);
    }

}
