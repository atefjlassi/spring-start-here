package com.repositories;

import com.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductRepository {

  private final JdbcTemplate jdbcTemplate;

  public void addProduct(Product product) {
    var sql = "INSERT INTO product VALUES(NULL, ?, ?)";
    jdbcTemplate.update(sql, ps -> )
    jdbcTemplate.update(sql, product.getName(), product.getPrice());
  }

  public List<Product> getProducts() {
    var sql = "SELECT * FROM product";
    return jdbcTemplate.query(sql, productRowMapper());
  }

  private RowMapper<Product> productRowMapper() {
    return new RowMapper<Product>() {
      @Override
      public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));

        return product;
      }
    };
  }
}
