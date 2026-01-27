package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // Step 5: /hello/test1 -> raw text
    @GetMapping("/test1")
    @ResponseBody
    public String printHello() {
        return "Hello World!";
    }
    
    // Step 10: /hello/test2 -> view + model attribute
    @GetMapping("/test2")
    public String printHello(Model model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    // Step 13: /hello/test3 -> ModelAndView
    @GetMapping("/test3")
    public ModelAndView printHello1() {
        // Creating a ModelAndView and the setting an attribute named message and with a View named hello
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World from ModelAndView!");
        mv.addObject("message2", "Another Hello World from ModelAndView!");
        mv.setViewName("hello");
        return mv;
    }

    // Step 16: /hello/test4?message=...
    @GetMapping("/test4")
    public String printHello(@RequestParam("message") String message, Model model) {
        //Simply returning a Model attribute named message and return a View named hello
        model.addAttribute("message", message);
        return "hello";
    }
}
