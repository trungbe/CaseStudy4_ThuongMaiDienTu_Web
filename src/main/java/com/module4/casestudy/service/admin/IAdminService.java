package com.module4.casestudy.service.admin;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAdminService {
    Page<LoginUser> findAll(Pageable pageable);
    Page<LoginUser> findUserRoleName(UserRole userRole, Pageable pageable);
}
