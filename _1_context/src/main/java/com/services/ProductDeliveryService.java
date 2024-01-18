package com.services;

import com.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeliveryService {

  /**
   * @Autowired
   * private final ProductRepository productRepository;
   * ERROR IF WE USE IT WITHOUT
   * CONSTRUCTOR
   *
   * if I make @Autowired above the field I couldn't make it final
   */

  /**
   *  we should make final whatever is need be final: things will not be change
   *  with final I make the component immutable,
   */
  private final ProductRepository productRepository;

  @Autowired
  public ProductDeliveryService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addSomeProducts() {
    productRepository.add();
    productRepository.add();
    productRepository.add();
  }
}
