package com.spring.rest;

import com.spring.dto.Person;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController_ {

  /**
   * a web service is an interface between a client that wants to call your use cases through web
   * and the services that you implement on the server side
   * provide path & verb to the client to call the API
   *
   * to pass information to our API:
   *    we can use: - @PathVariable .
   *                - @RequestBody . BUT be careful, @GetMapping doesn't allow you to have @RequestBody
   */

  /**
   *  @RequestMapping(method = RequestMethod.GET, path = "/hello_/{name}")
   */
  @GetMapping(path = "/hello_/{name}")
  public String hello(@PathVariable("name") String name) {
    return "Hello, "+name+" ! ";
  }

  /**
   * The Json of person will automatically deserialized
   */
  @PostMapping(path = "/goodbye")
  public String goodbye(@RequestBody Person person) {
    return "Goodbye " +person.getName();
  }

  @GetMapping(path = "/person")
  public Person getPerson() {
    return new Person().name("Issam");
  }

  @GetMapping(path = "/persons")
  public List<Person> getAllPerson() {
    return Arrays.asList(new Person().name("Issam"), new Person().name("Ali"));
  }

  @GetMapping(path = "/status")
  public Person status(HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    return new Person().name("Issam");
  }

}
