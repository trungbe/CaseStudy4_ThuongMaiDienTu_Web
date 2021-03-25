package com.module4.casestudy.repository;

import com.module4.casestudy.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<LoginUser, Long> {
    LoginUser getLoginUserByUsername(String username);
}
