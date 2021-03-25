package com.module4.casestudy.controllers.loginuser;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.Product;
import com.module4.casestudy.model.UserRole;
import com.module4.casestudy.service.admin.IUserRoleService;
import com.module4.casestudy.service.appuser.IAppUserService;
import com.module4.casestudy.service.loginuser.ILoginUserService;
import com.module4.casestudy.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class LoginUserController {
    @Autowired
    private ILoginUserService loginUserService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private IProductService productService;

    @ModelAttribute("listProduct")
    public List<Product> showAllProduct(){
        return productService.findALl();
    }

    @ModelAttribute("currentUser")
    private LoginUser user() {
        return appUserService.getCurrentUser();
    }

    @ModelAttribute("listUserRole")
    public List<UserRole> showAll() {
        return userRoleService.findALl();
    }

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("home/login");
        modelAndView.addObject("users", loginUserService.findALl());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new LoginUser());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createUser(@ModelAttribute LoginUser loginUser) {
        loginUserService.save(loginUser);
        return new ModelAndView("redirect:/users");
    }
}
