package com.dystify.kkdystrack3.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dystify.kkdystrack3.server.module.ui.UiModuleConfiguration;

@SpringBootApplication
//@PropertySource("resource/application.properties")
@EntityScan("com.dystify.kkdystrack3.server.dao.entity")
@EnableJpaRepositories("com.dystify.kkdystrack3.server.dao.repository")
@Import(UiModuleConfiguration.class)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}