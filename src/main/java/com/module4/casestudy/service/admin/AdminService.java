package com.module4.casestudy.service.admin;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.UserRole;
import com.module4.casestudy.repository.admin.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    @Override
    public Page<LoginUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<LoginUser> findUserRoleName(UserRole userRole, Pageable pageable) {
        return null;
    }

}
