package com.example.equipmentloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.equipmentloan.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
} 