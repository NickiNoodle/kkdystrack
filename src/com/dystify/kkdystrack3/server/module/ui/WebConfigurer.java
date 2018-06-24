package com.dystify.kkdystrack3.server.module.ui;

import java.io.File;
import java.net.MalformedURLException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dystify.kkdystrack3.common.Util;

@Configuration
@EnableWebMvc
public class WebConfigurer implements WebMvcConfigurer
{
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    try {
      File webroot = new File(Util.getResourceRootDir(), "server/web/template");
      String fsUri = webroot.toURI().toURL().toString();
      System.out.println("FS URI: \"" +fsUri+ "\"");
      registry.addResourceHandler("/**").addResourceLocations(fsUri);
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
