package com.dystify.kkdystrack3.core.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KKDystrackd implements CommandLineRunner
{

  @Override public void run(String... args) throws Exception {
    System.out.println("Starting KKDystrackd...");
    
  }
  
  
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(KKDystrackd.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    ConfigurableApplicationContext ctx = app.run(args);
  }
  
}
