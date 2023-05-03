package com.starter.braavos.braavosstarter.dao;

import com.starter.braavos.braavosstarter.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyDao extends JpaRepository<Bank, String> {
}
