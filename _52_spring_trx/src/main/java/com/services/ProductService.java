package com.services;

import com.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  /**
   * REQUIRED (default).
   * REQUIRES_NEW. -> create new transaction
   * NEVER.
   * NOT_SUPPORTED.
   * MANDATORY.
   * SUPPORTS
   * NESTED.
   *
   * a() -->b()
   */
  private final ProductRepository productRepository;


//  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  @Transactional
  public void addTenProduct() { // begin transaction
    for (var i = 1; i <= 10; i++) {
      // if addProduct use the default @Transaction (REQUIRED) = there is just only one transaction created
      // every thing will be executed in the same transaction
      productRepository.addProduct("Product_" + i);
      /* if (i == 5) {
        throw new RuntimeException(" : (");
      }*/
    }
  } // commit
}
