package com.spring.data.repositories;

import com.spring.data.entities.Product;
import java.util.List;
import javax.print.attribute.standard.PrinterURI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  public Product findFirstProductByName(String name);

  @Query("SELECT p FROM Product p WHERE p.name=: name")
  public Product findProductByName(String name);

//  @Query("SELECT p FROM Product p WHERE p.name=: test")
  @Query(value = "SELECT * FROM Product p WHERE p.name like name", nativeQuery = true)
  public List<Product> retreiveProductsByName(@Param("name") String name);
}
