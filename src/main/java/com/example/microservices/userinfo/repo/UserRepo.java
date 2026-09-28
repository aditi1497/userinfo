package com.example.microservices.userinfo.repo;

import com.example.microservices.userinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
