package com.ironstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileDetectorEPP implements EnvironmentPostProcessor {
  @Override
  public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
    String[] activeProfiles = environment.getActiveProfiles();

    if (activeProfiles.length == 0 && getTemperature() < -272) {
      environment.setActiveProfiles("зимаТута");
    } else {
      environment.setActiveProfiles("зимаБлизко");
    }
  }

  private int getTemperature() {
    return -300;
  }
}
