package com.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.repositories")
public class ProjectConfig {

  public static final String URL = "jdbc:mysql://localhost/demo";

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setUrl(URL);
    driverManagerDataSource.setUsername("root");
    driverManagerDataSource.setPassword("root");
    return driverManagerDataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
      return new JdbcTemplate(dataSource());
  }
}
