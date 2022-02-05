package com.iacademy.backEnd.repository;

import com.iacademy.backEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {

    List<User> findByName(String name);

    List<User> findAllByOrderByName();
}
