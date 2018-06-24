package com.dystify.kkdystrack3.server.module.ui;

import java.io.File;
import java.net.MalformedURLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import com.dystify.kkdystrack3.common.Util;

@Configuration
@EnableWebMvc
public class WebConfigurer implements WebMvcConfigurer
{
  @Autowired
  private SpringTemplateEngine templateEngine;
  
  
  @PostConstruct
  public void configureTemplateEngine() {
    System.out.println("Configuring Thymeleaf Template location...");
    File templateroot = new File(Util.getResourceRootDir(), "server/template/");
    FileTemplateResolver rs = new FileTemplateResolver();
    rs.setPrefix(templateroot.getAbsolutePath());
    rs.setSuffix(".html");
    rs.setTemplateMode("HTML5");
    rs.setOrder(templateEngine.getTemplateResolvers().size());
    rs.setCacheable(false);
    templateEngine.addTemplateResolver(rs);
  }
  
  
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    try {
      File webroot = new File(Util.getResourceRootDir(), "server/web");
      String fsUri = webroot.toURI().toURL().toString();
      registry.addResourceHandler("/**").addResourceLocations(fsUri);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }
}
