package com.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

  public String sayHello(String name) {
    String message = "Hello, " + name + "!";
    return message;
  }
}
