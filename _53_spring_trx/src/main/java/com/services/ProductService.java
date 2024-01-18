package com.services;

import com.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;


  /**
   * DEFAULT --> READ_COMMITTED
   * READ_COMMITTED
   * READ_UNCOMMITTED
   * REPEATABLE_READ
   * SERIALIZABLE
   *
   *
   * PROBLEMS:
   *
   */
  @Transactional(isolation = Isolation.READ_UNCOMMITTED)
  public void addTenProduct() {
    for (var i = 1; i <= 10; i++) {
      productRepository.addProduct("Product_" + i);
    }
  }

}
