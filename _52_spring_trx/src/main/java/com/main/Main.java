package com.main;

import com.config.ProjectConfig;
import com.services.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      ProductService productService = context.getBean(ProductService.class);
      productService.addTenProduct(); // no transaction
    }
  }

}
