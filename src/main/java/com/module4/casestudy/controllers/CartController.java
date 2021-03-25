package com.module4.casestudy.controllers;

import com.module4.casestudy.exception.NotFoundException;
import com.module4.casestudy.model.*;
import com.module4.casestudy.service.Bill.IBillService;
import com.module4.casestudy.service.admin.IAdminService;
import com.module4.casestudy.service.appuser.AppUserService;
import com.module4.casestudy.service.billDetail.IBillDetailService;
import com.module4.casestudy.service.category.ICategoryService;
import com.module4.casestudy.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cart")

public class CartController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private IBillService billService;
    @Autowired
    private IBillDetailService billDetailService;
    @Autowired
    private IAdminService adminService;

    @ModelAttribute("currentUser")
    private LoginUser getCurrentUser() {
        return appUserService.getCurrentUser();
    }


    @GetMapping("/productDetail/{id}")
    public ModelAndView showProductDetail(@PathVariable Long id) throws NotFoundException {
        ModelAndView modelAndView = new ModelAndView("/cart/productDetail");
        Product product = productService.findById(id);
        BillDetail billDetail = new BillDetail();
        billDetail.setProduct(product);
        modelAndView.addObject("billDetail", billDetail);
        return modelAndView;
    }

    @GetMapping("/getCart")
    public ModelAndView findProductOnCart() {
        LoginUser currentUser = this.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView("/cart/cart");
        List<BillDetail> productInCarts = new ArrayList<>();
        List<Bill> billList = billService.findBillNotPayByUserId(currentUser.getId());
        for (Bill b : billList) {
            List<BillDetail> billDetailList = billDetailService.findALlByBill(b);
            productInCarts.addAll(billDetailList);
        }

        modelAndView.addObject("productInCarts", productInCarts);
        return modelAndView;
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<BillDetail> addToCart(@RequestBody BillDetail billDetail) {
        LoginUser currentUser = this.getCurrentUser();
        List<Bill> bills = billService.findBillNotPayByUserId(currentUser.getId());
        BillDetail billDetail1 = setBillDetail(billDetail, currentUser, bills);

        billDetailService.save(billDetail1);
        return new ResponseEntity<>(billDetail1, HttpStatus.OK);

    }


    private BillDetail setBillDetail(BillDetail billDetail, LoginUser currentUser, List<Bill> bills) {

        if (bills.size() > 0) {
            for (int i = 0; i < bills.size(); i++) {
                //check to see if the same shop or not
                if (bills.get(i).getShop().getId().equals(billDetail.getProduct().getShop().getId())) {

                    //get all product of this shop in cart and compare to new product customer  want to buy
                    List<BillDetail> billDetailListInThisShop = billDetailService.findALlByBill(bills.get(i));
                    for (int j = 0; j < billDetailListInThisShop.size(); j++) {
                        //check if the same product in cart
                        if (billDetailListInThisShop.get(j).getProduct().getId().equals(billDetail.getProduct().getId())) {
                            //increase number of product in current cart
                            billDetailListInThisShop.get(j).setNumber(billDetailListInThisShop.get(j).getNumber() + billDetail.getNumber());
                            return billDetailListInThisShop.get(j);
                        }
                    }
                    // if in the same shop but product are different, set new billDetail id with already exist bill id.
                    billDetail.setBill(bills.get(i));
                    return billDetail;

                }
            }
            Bill bill = new Bill();
            bill.setLoginUser(currentUser);
            bill.setStatus(false);
            bill.setShop(billDetail.getProduct().getShop());
            //save bill to DB
            billService.save(bill);
            //get bill just have save to DB, and set new billDetail id with created bill id;
            List<Bill> bills1 = billService.findBillNotPayByUserId(currentUser.getId());
            for (Bill b : bills1) {
                billDetail.setBill(b);
            }

        } else {
            // if have no element in bill list, create new bill with below information
            Bill bill = new Bill();
            bill.setLoginUser(currentUser);
            bill.setStatus(false);
            bill.setShop(billDetail.getProduct().getShop());
            //save bill to DB
            billService.save(bill);
            //get bill just have save to DB, and set new billDetail id with created bill id;
            List<Bill> bills1 = billService.findBillNotPayByUserId(currentUser.getId());
            for (Bill b : bills1) {
                billDetail.setBill(b);
            }
        }
        return billDetail;

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BillDetail> deleteBillDetail(@PathVariable Long id) throws NotFoundException {
        BillDetail billDetail = billDetailService.findById(id);
        if (billDetail == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            billDetailService.deleteById(id);
            return new ResponseEntity<>(billDetail, HttpStatus.OK);
        }
    }


    @PutMapping("/checkout")
    public ResponseEntity<List<BillDetail>> checkout() {
        LoginUser currentUser = this.getCurrentUser();
        List<Bill> billList = billService.findBillNotPayByUserId(currentUser.getId());

        for (Bill bill : billList) {
            //with the payed bill, set status to true(payed)
            bill.setStatus(true);
            bill.setDate(new Date());
            bill.setTotalMoney(billDetailService.calculateMoneyByBillId(bill.getId()));
            billService.save(bill);

        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
