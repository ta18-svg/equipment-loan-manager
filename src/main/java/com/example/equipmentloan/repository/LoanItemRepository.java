package com.example.equipmentloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.equipmentloan.entity.LoanItem;

public interface LoanItemRepository extends JpaRepository<LoanItem, Long>{
    
}
