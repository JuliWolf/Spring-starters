package com.ironbank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BraavosStarterApplication {

  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(BraavosStarterApplication.class);
    builder.headless(false);
    builder.run(args);
  }

}
