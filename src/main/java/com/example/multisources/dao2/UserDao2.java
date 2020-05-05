package com.example.multisources.dao2;

import com.example.multisources.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao2 extends JpaRepository<User, Integer> {}
