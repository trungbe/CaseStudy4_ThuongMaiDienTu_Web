package com.module4.casestudy.repository;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findAllByLoginUser(LoginUser loginUser);
}
