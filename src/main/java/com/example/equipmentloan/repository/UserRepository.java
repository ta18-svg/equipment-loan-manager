package com.example.equipmentloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.equipmentloan.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
