package com.ironbank;

import com.ironstarter.RavenListener;
import com.ironstarter.RavenProperties;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@Component
public class MyRavenListener extends RavenListener {
  public MyRavenListener(RavenProperties ravenProperties) {
    super(ravenProperties);
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("event = " + event);
  }
}
