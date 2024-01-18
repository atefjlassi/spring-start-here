package com.config;

import com.beans.Cat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.beans")
public class ProjectConfig {


  /**  @Bean
  public Cat cat() {
    Cat cat = new Cat();
    cat.setName("Tom");
    return cat;
  }

  @Bean
  public Owner owner(Cat cat) { // inject by spring parameter
    Owner owner = new Owner();
    owner.setCat(cat);
    // owner.setCat(cat()); // will get the cat from the context
    return owner;
  }*/

  @Bean
//  @Primary
  @Qualifier("cat1")
  public Cat cat1() {
    Cat cat = new Cat();
    cat.setName("Tom");
    return cat;
  }

  @Bean
  @Qualifier("cat2")
  public Cat cat2() {
    Cat cat = new Cat();
    cat.setName("Leo");
    return cat;
  }
}
