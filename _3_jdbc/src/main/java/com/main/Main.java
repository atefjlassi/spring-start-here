package com.main;

import com.config.ProjectConfig;
import com.models.Product;
import com.repositories.ProductRepository;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

      ProductRepository productRepository = context.getBean(ProductRepository.class);
//      productRepository.addProduct(new Product(0, "Choclate", 120));

      List<Product> products = productRepository.getProducts();
      products.forEach(System.out::println);
    }
  }

}
