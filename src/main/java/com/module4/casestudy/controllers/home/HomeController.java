package com.module4.casestudy.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home")
public class HomeController {
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home/home");
        return modelAndView;
    }
}
