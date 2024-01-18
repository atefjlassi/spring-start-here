package com.spring.data.rest;

import com.spring.data.entities.Product;
import com.spring.data.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping(path = "/add")
  public void addProduct(@RequestBody Product product) {
    this.productRepository.save(product);
  }

  @GetMapping(path = "/sort")
  public Iterable<Product> getAllSortedDescendingById() {
    return this.productRepository.findAll(Sort.by("id").descending());
  }

  // pages start from index zero = 0
  @GetMapping(path = "/page/{page}")
  public Iterable<Product> getProductsByPage(@PathVariable int page) {
    Sort sort = Sort.by("id").descending();
    return this.productRepository.findAll(PageRequest.of(page, 3, sort)).getContent();
  }

  @GetMapping(path = "/name/{name}")
  public Iterable<Product> getProductsByName(@PathVariable String name) {
    Sort sort = Sort.by("id").descending();
    return this.productRepository.findProductByNameIgnoreCase(name, sort);
  }

  @GetMapping(path = "/name/{name}/{page}")
  public Iterable<Product> getProductsPageByName(@PathVariable String name, @PathVariable int page) {

    Pageable pageable = PageRequest.of(page, 2);
    return this.productRepository.findProductByNameContainingIgnoreCase(name, pageable);
  }

}
