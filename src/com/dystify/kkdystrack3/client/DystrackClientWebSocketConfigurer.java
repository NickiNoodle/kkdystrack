package com.dystify.kkdystrack3.client;

import com.dystify.kkdystrack3.client.handler.TestHandler;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.apache.tomcat.websocket.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import javax.net.ssl.*;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DystrackClientWebSocketConfigurer {

  public static void init() throws Exception {
    WebSocketClient client = new StandardWebSocketClient();

    SSLContext context = SSLContexts.custom().loadTrustMaterial(new TrustSelfSignedStrategy()).build();
    Map<String, Object> properties = new HashMap<>();
    properties.put(Constants.SSL_CONTEXT_PROPERTY, context);
    ((StandardWebSocketClient) client).setUserProperties(properties);

    WebSocketStompClient stompClient = new WebSocketStompClient(client);
    stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

    StompSessionHandler handler = new TestHandler();

    // Can probably get this from some kind of config file
    String url = "wss://127.0.0.1:8000/data";

    stompClient.connect(url, handler);
  }
}
