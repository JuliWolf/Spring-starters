package com.ironstarter;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

public class OnRavenCondition extends AllNestedConditions {
  public OnRavenCondition() {
    super(ConfigurationPhase.REGISTER_BEAN);
  }

  @ConditionalOnProperty("ворон.куда")
  public static class R {}

  @ConditionalOnProperty(value = "ворон.вкл", havingValue = "true")
  public static class C {}
}
