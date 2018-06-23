package com.dystify.kkdystrack3.server.module.websocket.controller;

import com.dystify.kkdystrack3.common.pojo.TestPojo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @MessageMapping("/data")
    @SendTo("/socket/newitem")
    public TestPojo test(TestPojo test) throws Exception {
        return new TestPojo(test.getContent());
    }
  }
