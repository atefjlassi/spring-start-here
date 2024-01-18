package com.main;

import com.config.ProjectConfig;
import com.services.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      HelloService helloService = context.getBean(HelloService.class);
      String message = helloService.sayHello("John");
      System.out.println("Result is : "+message);
//      System.out.println(message);
    }
  }

}