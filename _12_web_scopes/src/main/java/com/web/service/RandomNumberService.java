package com.web.service;

import java.util.Random;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RandomNumberService {
  private final int value;

  public RandomNumberService() {
    this.value = new Random().nextInt(1000);
  }

  public int getValue() {
    return value;
  }
}
