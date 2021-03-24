package com.module4.casestudy.service.admin;

import com.module4.casestudy.exception.NotFoundException;
import com.module4.casestudy.model.UserRole;
import com.module4.casestudy.repository.admin.IUserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private IUserRoleRepo userRoleRepo;

    @Override
    public List<UserRole> findALl() {
        return (List<UserRole>) userRoleRepo.findAll();
    }

    @Override
    public Page<UserRole> findALl(Pageable pageable) {
        return null;
    }

    @Override
    public UserRole findById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
