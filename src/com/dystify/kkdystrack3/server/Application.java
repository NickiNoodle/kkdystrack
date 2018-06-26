package com.dystify.kkdystrack3.server;

import com.dystify.kkdystrack3.server.module.websocket.WebSocketModuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dystify.kkdystrack3.server.module.ui.UiModuleConfiguration;

@SpringBootApplication
// @PropertySource("classpath:/src/com/dystify/kkdystrack3/server/resource/server.properties")
@EntityScan("com.dystify.kkdystrack3.server.dao.entity")
@EnableJpaRepositories("com.dystify.kkdystrack3.server.dao.repository")
@Import({UiModuleConfiguration.class, WebSocketModuleConfiguration.class})
public class Application {

  public static void main(String[] args) {
    System.out.println("Hello debug!");
    SpringApplication.run(Application.class, args);
  }

}