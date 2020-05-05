package com.example.multisources.dao1;

import com.example.multisources.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao1 extends JpaRepository<User,Integer> {}
