package com.ironbank.dao;

import com.ironbank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyDao extends JpaRepository<Bank, String> {
}
