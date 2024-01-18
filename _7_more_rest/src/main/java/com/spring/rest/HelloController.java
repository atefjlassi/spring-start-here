package com.spring.rest;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @PostMapping(path = "/test/{name}")
  public String test(@RequestHeader String a,
                      @RequestHeader String b,
                      @RequestHeader String c,
                      @PathVariable("name") String name,
                      HttpServletResponse response, HttpServletRequest request) {

    response.addHeader("test", "good");
    return a + b + c + "/" + name;
  }

  @GetMapping(path = "/all")
  public Map<String, String> all(@RequestHeader Map<String, String> map) {
    return map;
  }

  @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
  public byte[] file() {
      byte[] file = new byte[100];

    return file;
  }
}