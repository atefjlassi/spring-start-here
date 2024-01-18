package com.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class ProductRepository {
  private final JdbcTemplate jdbcTemplate;

//  @Transactional(propagation = Propagation.REQUIRES_NEW)
//  @Transactional(propagation = Propagation.MANDATORY)
  @Transactional(propagation = Propagation.NEVER)
  public void addProduct(String name) {

    var sql = "INSERT INTO product_ VALUES(NULL, ?)";
    jdbcTemplate.update(sql, name);
  }
}
