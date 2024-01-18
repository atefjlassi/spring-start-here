package com.config;

import com.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.beans", "com.repositories", "com.services"})
public class ProjectConfig {

  /**
   * This is the first way, here we can do some initialization of the instance before place it on
   * the context.
   */
  @Bean("A")
  public MyBean myBean1() {
    MyBean myBean = new MyBean();
    myBean.setText("Hello");
    return myBean;
  }

  @Bean("B")
  @Primary
  public MyBean myBean2() {
    MyBean myBean = new MyBean();
    myBean.setText("World");
    return myBean;
  }
}
