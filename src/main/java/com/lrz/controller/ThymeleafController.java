package com.lrz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gz000172 on 2018/6/17.
 */
@Controller
@RequestMapping("/thy")
public class ThymeleafController {
    @GetMapping("/index")
    public ModelAndView index(Model model) {
        model.addAttribute("hello", "Hello Spring Boot And Thymeleaf");
        return  new ModelAndView("thy/index");
    }

    @GetMapping("/react")
    public ModelAndView react(Model model, @RequestParam(defaultValue = "lurongze") String name){
        model.addAttribute("hello", "Hello Spring Boot And Thymeleaf And React");
        model.addAttribute("name", name);
        return new ModelAndView("thy/react");
    }
}
