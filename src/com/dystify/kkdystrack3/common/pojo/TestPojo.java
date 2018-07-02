package com.dystify.kkdystrack3.common.pojo;

public class TestPojo {
  private String content;

  public TestPojo() {
  }

  public TestPojo(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "TestPojo {content: " + this.getContent() + "}";
  }
}
