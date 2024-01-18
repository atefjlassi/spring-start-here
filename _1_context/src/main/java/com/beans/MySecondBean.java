package com.beans;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MySecondBean {

  private String text;

  @PostConstruct
  private void init() {
    this.text = "HELLO GUYS !";
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
