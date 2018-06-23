package com.dystify.kkdystrack3.client.handler;

import com.dystify.kkdystrack3.common.pojo.TestPojo;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class TestHandler extends StompSessionHandlerAdapter {

  @Override
  public void afterConnected(StompSession session, StompHeaders headers) {
    session.subscribe("/socket/newitem", this);
    session.send("/app/data", "{\"content\":\"Client\"}".getBytes());

    System.out.println("New Session!");
  }

  @Override
  public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
    exception.printStackTrace();
  }

  @Override
  public Type getPayloadType(StompHeaders header) {
    return TestPojo.class;
  }

  @Override
  public void handleFrame(StompHeaders header, Object payload) {
    System.out.println("Received payload: " + ((TestPojo) payload).getContent());
  }
}
