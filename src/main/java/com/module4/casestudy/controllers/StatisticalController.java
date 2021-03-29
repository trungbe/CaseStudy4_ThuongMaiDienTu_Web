package com.module4.casestudy.controllers;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.service.appuser.IAppUserService;
import com.module4.casestudy.service.statistical.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/statistical")
public class StatisticalController {
    @Autowired
    private StatisticalService statisticalService;
    @Autowired
    private IAppUserService appUserService;

    @ModelAttribute("currentUser")
    private LoginUser user() {
        return appUserService.getCurrentUser();
    }

    @ModelAttribute("currentShop")

    @GetMapping("/month")
    public ModelAndView showFormStatistical() {
        ModelAndView modelAndView = new ModelAndView("shop/statistical/month");
        return modelAndView;
    }

    //    @GetMapping("/month")
//    public Long getTotalByMonth(@RequestParam int month, Long userId) {
//        Long result = statisticalService.getDataByMonth(month, userId);
//        return result;
//    }
//    @GetMapping("/month")
//    public Long getTotalByMonth1(@PathVariable int month, Long userId) {
//        Long result = statisticalService.getDataByMonth(month, appUserService.getCurrentUser().getId());
//        return result;
//    }
    @GetMapping("/getMonth")
    public ModelAndView findTotalByMonth(@RequestParam Integer month) {
        Long result = statisticalService.getDataByMonth(month, appUserService.getCurrentUser().getId());
        return new ModelAndView("shop/statistical/month", "totalByMonth", result);
    }
}
