package com.module4.casestudy.model;


import javax.persistence.*;
import java.util.Date;


@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shop shop;



    @ManyToOne
    private LoginUser loginUser;

    private Double TotalMoney;

    private Date date;

    private Boolean status;

    public Bill() {
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public Double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        TotalMoney = totalMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
