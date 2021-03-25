package com.module4.casestudy.repository;

import com.module4.casestudy.model.Product;
import com.module4.casestudy.model.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
