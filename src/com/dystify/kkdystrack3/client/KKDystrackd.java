package com.dystify.kkdystrack3.client;

import com.dystify.kkdystrack3.client.handler.TestHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@SpringBootApplication
public class KKDystrackd implements CommandLineRunner
{

  @Override public void run(String... args) throws Exception {
    System.out.println("Starting KKDystrackd...");
    
  }
  
  
  public static void main(String[] args) {
    WebSocketClient client = new StandardWebSocketClient();
    WebSocketStompClient stompClient = new WebSocketStompClient(client);
    stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

    // probably can get this from a conf file
    String url = "ws://127.0.0.1:8000/data";
    StompSessionHandler handler = new TestHandler();
    stompClient.connect(url, handler);

    SpringApplication app = new SpringApplication(KKDystrackd.class);
//    app.setWebApplicationType(WebApplicationType.NONE);
    ConfigurableApplicationContext ctx = app.run(args);
  }
  
}
