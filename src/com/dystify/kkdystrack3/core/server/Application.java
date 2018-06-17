package com.dystify.kkdystrack3.core.server;

import com.dystify.kkdystrack3.module.ui.UiModuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.dystify.kkdystrack3.dao.entity")
@EnableJpaRepositories("com.dystify.kkdystrack3.dao.repository")
@Import(UiModuleConfiguration.class)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}