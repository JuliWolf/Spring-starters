package com.ironstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {
  @Autowired
  private final RavenProperties ravenProperties;

  public RavenListener(RavenProperties ravenProperties) {
    this.ravenProperties = ravenProperties;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    ravenProperties.getКуда().forEach(s -> {
      System.out.println("отправляем ворона... в " + s);
    });
  }
}
