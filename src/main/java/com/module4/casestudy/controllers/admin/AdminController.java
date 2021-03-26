package com.module4.casestudy.controllers.admin;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.UserRole;
import com.module4.casestudy.service.admin.AdminService;
import com.module4.casestudy.service.admin.UserRoleService;
import com.module4.casestudy.service.loginuser.ILoginUserService;
import com.module4.casestudy.service.loginuser.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private ILoginUserService loginUserService;

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
        ModelAndView modelAndView = new ModelAndView("admin/adminList");
        modelAndView.addObject("admin", adminService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/classify")
    public ModelAndView searchByName(@ModelAttribute UserRole userRole, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("admin/adminList");
        modelAndView.addObject("admin", adminService.findUserRoleName(userRole, pageable));
        return modelAndView;
    }

    @PutMapping("/list/{id}")
    private ResponseEntity<LoginUser> disableUser(@PathVariable Long id){
        LoginUser loginUser = this.loginUserService.findById(id);
        if (loginUser.isDisable()==true){
            loginUser.setDisable(false);
        } else {
            loginUser.setDisable(true);
        }
        loginUserService.save(loginUser);
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }

}
