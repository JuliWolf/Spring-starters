package com.ironbank;

import com.ironbank.model.ProphetProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProphetProperties.class)
public class BraavosStarterApplication {

  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(BraavosStarterApplication.class);
    builder.headless(false);
    builder.run(args);
  }

}
