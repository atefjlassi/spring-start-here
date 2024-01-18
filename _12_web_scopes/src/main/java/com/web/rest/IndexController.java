package com.web.rest;

import com.web.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @Autowired
  private RandomNumberService randomNumberService;

  @GetMapping("/home")
  public String indexAction(Model model) {
    model.addAttribute("message", randomNumberService.getValue());
    return "index";
  }

}
