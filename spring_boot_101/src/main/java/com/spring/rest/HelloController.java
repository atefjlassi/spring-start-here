package com.spring.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@ResponseBody*/
@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {
    // by default spring boot will search a web page in /resources/static folder with name Hello and render it.
    // if we add @ResponseBody it will return "Hello" word
    // we can replace @Controller & @ResponseBody with @RestController annotation
    return "Hello";
  }
}
