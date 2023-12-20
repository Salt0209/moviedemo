package com.bkacad.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/welcome")
public class HelloController {
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String instruct(ModelMap model){
      model.addAttribute("message", "Hello Spring MVC Framework!");

      return "hello";
    }
    
}
