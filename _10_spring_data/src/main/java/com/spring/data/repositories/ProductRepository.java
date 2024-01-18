package com.spring.data.repositories;

import com.spring.data.entities.Product;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// when we use jdbc dependency instead of JPA

@Repository
//public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
public interface ProductRepository extends CrudRepository<Product, Integer> {


  @Query("SELECT * FROM product_ WHERE name=:name")
  List<Product> findProductByName(String name);

}
