package com.ironstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("ворон")
public class RavenProperties {
  public List<String> getКуда() {
    return куда;
  }

  public void setКуда(List<String> куда) {
    this.куда = куда;
  }

  List<String> куда;
}
