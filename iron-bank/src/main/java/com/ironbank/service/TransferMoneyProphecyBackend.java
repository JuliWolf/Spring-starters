package com.ironbank.service;

import com.ironbank.dao.MoneyDao;
import com.ironbank.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransferMoneyProphecyBackend implements TransferMoneyService {
  private final MoneyDao moneyDao;
  private final ProphetService prophet;

  @Autowired
  public TransferMoneyProphecyBackend(MoneyDao moneyDao, ProphetService prophet) {
    this.moneyDao = moneyDao;
    this.prophet = prophet;
  }

  @Override
  public long transfer(String addresseeName, long amount) {
    Bank bank = moneyDao.findAll().get(0);

    if (bank.getTotalAmount() > amount && prophet.willSurvive(addresseeName)) {
      bank.credit(amount);
      return moneyDao.save(bank).getTotalAmount();
    }

    return -1;
  }
}
