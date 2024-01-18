package com.spring.service;

import com.spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addProduct(String name) {
    this.productRepository.addProduct(name);
  }
}
