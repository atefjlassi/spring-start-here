package com.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

  private final JdbcTemplate jdbcTemplate;

  public ProductRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void addProduct(String name) {
    var sql = "insert into product_ values(null, ?)";
    jdbcTemplate.update(sql, name);


  }
}
