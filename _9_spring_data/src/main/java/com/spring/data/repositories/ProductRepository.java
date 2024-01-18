package com.spring.data.repositories;

import com.spring.data.entities.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

  List<Product> findProductByNameIgnoreCase(String name, Sort sort);
  List<Product> findProductByNameContainingIgnoreCase(String name, Pageable pageable);

}
