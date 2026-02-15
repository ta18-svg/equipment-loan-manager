package com.example.equipmentloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.equipmentloan.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
    
}
