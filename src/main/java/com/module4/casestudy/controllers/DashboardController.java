package com.module4.casestudy.controllers;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.service.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DashboardController {
    @Autowired
    private AppUserService appUserService;
    @ModelAttribute("currentUser")
    private LoginUser getCurrentUser() {
        return appUserService.getCurrentUser();
    }
    @GetMapping("/dashboard")
    public String home() {
        return "/shop/home";
    }
}

