package com.ironbank.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@ConfigurationProperties("ironbank")
public class ProphetProperties {
  List<String> теКтоВозвращаютДолги;

  public List<String> getТеКтоВозвращаютДолги() {
    return теКтоВозвращаютДолги;
  }

  public void setТеКтоВозвращаютДолги(List<String> теКтоВозвращаютДолги) {
    this.теКтоВозвращаютДолги = теКтоВозвращаютДолги;
  }

  public ProphetProperties(List<String> теКтоВозвращаюДолги) {
    this.теКтоВозвращаютДолги = теКтоВозвращаюДолги;
  }

  public ProphetProperties() {
  }
}
