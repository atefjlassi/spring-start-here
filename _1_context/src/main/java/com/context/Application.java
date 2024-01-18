package com.context;

import com.beans.MyBean;
import com.beans.MySecondBean;
import com.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

  /**
   * XML, Annotations
   */
  public static void main(String[] args) {

    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      System.out.println("-- THE FIRST WAY --");
      /**
       * first way to put/place bean in the context
       */
      // GET BEAN BY TYPE: you only specify the type of the instance
      MyBean b1 = context.getBean(MyBean.class);
      MyBean b2 = context.getBean(MyBean.class);
      MyBean b3 = context.getBean(MyBean.class);

    /** GET BEAN BY NAME: you specify the name of the requested bean
     * by default the name of the bean is the name of the method, Eg = 'myBean1'
     * otherwise you can specify the name of the bean within @Bean("myNewBeanName")
     */
      MyBean myBean1 = context.getBean("A", MyBean.class);
      System.out.println("my bean: " + myBean1.getText());

      System.out.println(b1.getText());
      System.out.println(b2.getText());
      System.out.println(b3.getText());

      System.out.println("test equality: " + b1.equals(b2));

      /**
       * Second way to put beans on the context using @Component and get the bean from the context
       * @see com.beans.MySecondBean
       * @NoSuchBeanDefinitionException thrown if the beans does not exit on the context
       * org.springframework.beans.factory.NoSuchBeanDefinitionException.
       * No qualifying bean of type 'com.beans.MySecondBean' available
       * solution: need @ComponentScan() annotation in the config class @{@link ProjectConfig} to be scanned
       */
      System.out.println("-- THE SECOND WAY --");
      MySecondBean mySecondBean = context.getBean(MySecondBean.class);
      System.out.println(mySecondBean.getText());

      System.out.println("-- HORS CONTEXT --");
      MySecondBean mySecondBean1 = new MySecondBean();
      System.out.println(mySecondBean1.getText());

    }

  }

}
