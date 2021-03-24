package com.module4.casestudy.controllers.admin;

import com.module4.casestudy.model.UserRole;
import com.module4.casestudy.service.admin.AdminService;
import com.module4.casestudy.service.admin.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRoleService userRoleService;

    @ModelAttribute("userRoles")
    public Iterable<UserRole> userRoles() {
        return userRoleService.findALl();
    }

    @ModelAttribute("userRole")
    public UserRole sendUserRole() {
        return new UserRole();
    }

    @Autowired
    private AdminService adminService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView showALl(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("admin/list");
        modelAndView.addObject("admin", adminService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView searchByName(@ModelAttribute UserRole userRole, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("admin/list");
        modelAndView.addObject("admin", adminService.findUserRoleName(userRole, pageable));
        return modelAndView;
    }
}
