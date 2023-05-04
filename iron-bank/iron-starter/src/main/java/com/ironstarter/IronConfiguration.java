package com.ironstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IronConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public RavenListener ravenListener () {
    return new RavenListener();
  }
}
