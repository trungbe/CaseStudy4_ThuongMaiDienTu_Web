package com.module4.casestudy.controllers.product;

import com.module4.casestudy.exception.NotFoundException;
import com.module4.casestudy.model.Category;
import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.Product;
import com.module4.casestudy.model.Shop;
import com.module4.casestudy.service.appuser.IAppUserService;
import com.module4.casestudy.service.category.ICategoryService;
import com.module4.casestudy.service.product.IProductService;
import com.module4.casestudy.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private Environment environment;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private IShopService shopService;

    @ModelAttribute("currentUser")
    private LoginUser user() {
        return appUserService.getCurrentUser();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findALl();
    }

    @ModelAttribute("currentShop")
    private Shop shop() {
        LoginUser currentUser = this.user();
        Shop shop = shopService.findAllByLoginUser(currentUser);
        return shop;
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView showNotFound() {
        return new ModelAndView("error-404");
    }

    @GetMapping("")
    public ModelAndView getAll(@PageableDefault(size = 3) Pageable pageable) {
        Shop shop = this.shop();
        Page<Product> products = productService.getAllProductByShop(shop, pageable);
        ModelAndView modelAndView = new ModelAndView("shop/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("shop/product/create");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product) throws IOException {
        MultipartFile imageMul = product.getImageMul();
        String image = imageMul.getOriginalFilename();
        String resource = environment.getProperty("upload.path").toString();
        FileCopyUtils.copy(imageMul.getBytes(), new File(resource + image));
        product.setImage(image);
        product.setShop(this.shop());
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("shop/product/create", "products", new Product());
        modelAndView.addObject("mess", "Tao moi thanh cong product ten la " + product.getName());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Product products = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("shop/product/edit");
        modelAndView.addObject("product", products);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Product product) throws IOException {
        MultipartFile imageMul = product.getImageMul();
        String image = imageMul.getOriginalFilename();
        String resource = environment.getProperty("upload.path").toString();
        FileCopyUtils.copy(imageMul.getBytes(), new File(resource + image));
        product.setShop(this.shop());
        product.setImage(image);
        productService.save(product);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable long id) {
        return new ModelAndView("/shop/product/view", "product", productService.findById(id));
    }

}
