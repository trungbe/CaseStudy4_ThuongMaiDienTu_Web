package com.module4.casestudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/statistical/month")
public class StatisticalController {
    @GetMapping("")
    public ModelAndView showFormStatistical(){
        ModelAndView modelAndView = new ModelAndView("shop/statistical/month");
        return modelAndView;
    }
}
