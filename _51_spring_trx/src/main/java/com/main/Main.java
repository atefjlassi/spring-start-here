package com.main;

import com.config.ProjectConfig;
import com.services.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) throws Exception {
    try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

      ProductService service = context.getBean(ProductService.class);
      service.addOneProduct();


    }
  }

}
