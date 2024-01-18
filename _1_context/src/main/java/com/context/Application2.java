package com.context;

import com.config.ProjectConfig;
import com.services.ProductDeliveryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application2 {

  public static void main(String[] args) {

    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

      ProductDeliveryService productService = context.getBean(ProductDeliveryService.class);
      productService.addSomeProducts();
    }

  }

}
