package com.example.sweater.database.repos;

import com.example.sweater.database.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Users findByActivationCode(String code);
}
