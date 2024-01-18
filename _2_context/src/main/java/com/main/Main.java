package com.main;

import com.beans.Owner;
import com.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
//      Cat cat = context.getBean(Cat.class);
      Owner owner = context.getBean(Owner.class);

      /* cat.setName("Lea");

      System.out.println(cat);*/
      System.out.println(owner);

    // System.out.println(cat.equals(owner.getCat()));
    }
  }

}
