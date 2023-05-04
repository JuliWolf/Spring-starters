package com.ironbank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Entity
public class Bank {
  @Id
  long id;

  long totalAmount;

  public void credit(long amount){
    totalAmount -= amount;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(long totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Bank() {
  }

  public Bank(long totalAmount) {
    this.totalAmount = totalAmount;
  }
}
