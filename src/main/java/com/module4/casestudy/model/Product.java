package com.module4.casestudy.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30, message = "Please fill out from 2 to 30 characters ! ")
    private String name;

    @Min(value = 10, message = "Please fill out minimum 10k")
    private Double price;
    @NotEmpty(message = "Please fill out description")
    private String description;
    @NotNull
    private Date date_time;
    @Min(value = 1, message = "Please fill out minimum 1 quantity")
    private Long quantity;

    private String image;
    @Transient
    private MultipartFile imageMul;
    private Long soldNumber;
    private Double rate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Shop shop;

    public Product(Long id, @Size(min = 2, max = 30, message = "Please fill out from 2 to 30 characters ! ") String name, @Min(value = 10, message = "Please fill out minimum 10k") Double price, @NotEmpty(message = "Please fill out description") String description, @NotNull Date date_time, @Min(value = 1, message = "Please fill out minimum 1 quantity") Long quantity, String image, MultipartFile imageMul, Long soldNumber, Double rate, Category category, Shop shop) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.date_time = date_time;
        this.quantity = quantity;
        this.image = image;
        this.imageMul = imageMul;
        this.soldNumber = soldNumber;
        this.rate = rate;
        this.category = category;
        this.shop = shop;
    }

    public Product() {
    }

    public MultipartFile getImageMul() {
        return imageMul;
    }

    public void setImageMul(MultipartFile imageMul) {
        this.imageMul = imageMul;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(Long soldNumber) {
        this.soldNumber = soldNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
