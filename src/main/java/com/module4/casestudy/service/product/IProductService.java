package com.module4.casestudy.service.product;


import com.module4.casestudy.model.Product;
import com.module4.casestudy.model.Shop;
import com.module4.casestudy.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService extends IService<Product> {
    Page<Product> getAllProductByShop(Shop shop, Pageable pageable);

}
