package com.dystify.kkdystrack3.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class KKDystrackd implements CommandLineRunner
{

  private static Logger LOG = Logger.getLogger(KKDystrackd.class.getName());

  @Override public void run(String... args) throws Exception {
    System.out.println("Starting KKDystrackd...");
  }
  
  public static void main(String[] args) {
    try {
      DystrackClientWebSocketConfigurer.init();
      SpringApplication app = new SpringApplication(KKDystrackd.class);
      ConfigurableApplicationContext ctx = app.run(args);
    } catch (Exception e) {
      KKDystrackd.LOG.severe("Failed to create websocket connection. Aborting.");
      e.printStackTrace();
    }
  }
  
}
