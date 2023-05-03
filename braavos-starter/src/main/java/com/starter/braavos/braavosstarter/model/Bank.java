package com.starter.braavos.braavosstarter.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Bank {
  @Id long id;
  long totalAmount;

  public void credit(long amount){
    totalAmount -= amount;
  }
}
