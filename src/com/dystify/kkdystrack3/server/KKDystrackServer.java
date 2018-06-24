package com.dystify.kkdystrack3.server;

import com.dystify.kkdystrack3.server.module.websocket.WebSocketModuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dystify.kkdystrack3.server.module.ui.UiModuleConfiguration;

@SpringBootApplication
@EntityScan("com.dystify.kkdystrack3.server.dao.entity")
@EnableJpaRepositories("com.dystify.kkdystrack3.server.dao.repository")
@Import({UiModuleConfiguration.class, WebSocketModuleConfiguration.class})
public class KKDystrackServer {

  public static void main(String[] args) {
    SpringApplication.run(KKDystrackServer.class, args);
  }

}