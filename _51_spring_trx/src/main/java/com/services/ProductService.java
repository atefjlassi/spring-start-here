package com.services;

import com.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  /**
   * by default @Transactional rollback runtime exception but does not rollback checked exception
   */

  //  @Transactional(rollbackFor = Exception.class)
  @Transactional
  public void addOneProduct() throws Exception {
    productRepository.addProduct("Beer");
    try {
      // in this case the rollback will not be executed because of the try catch bloc
      // l'exception n'est pas propagé a l'exterieur, elle traité localement donc =
      // le rollback ne se déclanche pas
      throw new RuntimeException(" :(");
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
//    throw new Exception(":(");
//    throw new RuntimeException(" :(");
  }
}
