package com.dystify.kkdystrack3.server.module.websocket.controller;

import com.dystify.kkdystrack3.common.pojo.TestPojo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class TestController {

  private static final Logger LOG = Logger.getLogger(TestController.class.getName());

  @MessageMapping("/data")
  @SendTo("/socket/newitem")
  public TestPojo test(TestPojo test) throws Exception {
    TestController.LOG.info("Processing " + test.toString());
    return new TestPojo(test.getContent());
  }
}
