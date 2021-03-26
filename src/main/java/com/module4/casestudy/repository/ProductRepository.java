package com.module4.casestudy.repository;

import com.module4.casestudy.model.Product;
import com.module4.casestudy.model.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> getAllByShop(Shop shop, Pageable pageable);

    @Query(value = "select * from product", nativeQuery = true)
    List<Product> showAllProduct();

    //tim kiem theo ten
    @Query(value = "select * from product where product.name like ?", nativeQuery = true)
    List<Product> findProductByName(String name);
}
