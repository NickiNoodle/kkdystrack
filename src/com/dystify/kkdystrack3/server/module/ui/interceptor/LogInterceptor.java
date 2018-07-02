package com.dystify.kkdystrack3.server.module.ui.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class LogInterceptor extends HandlerInterceptorAdapter {
  private static final Logger LOG = Logger.getLogger(LogInterceptor.class.getName());

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    LogInterceptor.LOG.info(request.getRequestURI());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
    if (exception != null) {
      LogInterceptor.LOG.severe("Exception " + exception.getClass().getName() + "thrown  at request " + request.getRequestURI());
      exception.printStackTrace();
    }
  }

}