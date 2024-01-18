package com.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Aspect it's not a streotype annotation, no beans will be created in context of type HSA
 */

@Aspect
@Component
public class HelloServiceAspect {

  /**
   * here will specify the logic to decouple for my normal business code
   */

  // Before the execution of the method
  // @Before("execution(* com.services.HelloService.sayHello(..))")
  public void before() {
    System.out.println("A");
  }

  // After the execution of the method :: no matter if there is an exception or not
  //  @After("execution(* com.services.HelloService.sayHello(..))")
  public void after() {
    System.out.println("B");
  }

  // Only if the execution of the method happen without an exception
  //  @AfterReturning("execution(* com.services.HelloService.sayHello(..))")
  public void afterReturning() {
    System.out.println("C");
  }


  // Only if an exception throws
  //  @AfterThrowing("execution(* com.services.HelloService.sayHello(..))")
  public void afterThrowing() {
    System.out.println("D");
  }

  /**
   * @param joinPoint : it represents the intercepted method, the intercepted method not executed at
   *                  more if we don't use jointPoint parameter. the method represented by joinPoint
   *                  parameter use jointPoint parameter to explicitly specify that I want to
   *                  proceed with the execution of the method
   * @return
   */
  /**
   *  it's not recommended to replace the logic of the method, this is just a demo
   *  use Aspect as decorator not to replace logic
   *  decorator means => add functionality to replace functionality
   * */
  @Around("execution(* com.services.HelloService.sayHello(..))")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//    System.out.println("Something else !!!");
    System.out.println("A");
//    Object res = joinPoint.proceed();
    Object res = joinPoint.proceed(new Object[] {"Bill"}); // change the passed parameter from john to bill
    StringBuilder result = new StringBuilder((String) res + " - COCO");
    System.out.println(result);
    System.out.println("B");

    return result.toString();
  }
}
