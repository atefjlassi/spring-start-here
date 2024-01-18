package com.spring.data.rest;

import com.spring.data.entities.Product;
import com.spring.data.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {


  private ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostMapping(path = "/add")
  public void addProduct(@RequestBody Product product) {
    this.productRepository.save(product);
  }


  @GetMapping(path = "/name/{name}")
  public List<Product> getProductsByName(@PathVariable String name) {
    return this.productRepository.findProductByName(name);
  }


}
