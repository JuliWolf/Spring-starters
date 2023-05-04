package com.ironbank.controller;

import com.ironbank.dao.MoneyDao;
import com.ironbank.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
public class IronBankController {

  private final TransferMoneyService transferMoney;
  private final MoneyDao moneyDao;

  @Autowired
  public IronBankController(TransferMoneyService transferMoney, MoneyDao moneyDao) {
    this.transferMoney = transferMoney;
    this.moneyDao = moneyDao;
  }

  @GetMapping("/credit")
  public String credit(@RequestParam String name, @RequestParam long amount) {
    long resultedDeposit = transferMoney.transfer(name, amount);

    if (resultedDeposit == -1) {
      return "Rejected</br>" + name + " <b>will't</b> survive this winter";
    }

    return format(
        "<i>Credit approved for %</i> <br/> Current bank balance: <b>%s</b>",
        name,
        resultedDeposit
    );
  }

  @GetMapping("/state")
  public long currentState() {
    return moneyDao.findAll().get(0).getTotalAmount();
  }
}
