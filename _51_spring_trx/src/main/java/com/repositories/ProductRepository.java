package com.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

  private final JdbcTemplate jdbcTemplate;

  public void addProduct(String name) {
    var sql = "INSERT INTO product_ VALUES(NULL, ?)";
    jdbcTemplate.update(sql, name);
  }
}
