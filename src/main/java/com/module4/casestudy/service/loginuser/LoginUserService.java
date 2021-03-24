package com.module4.casestudy.service.loginuser;

import com.module4.casestudy.exception.NotFoundException;
import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.repository.loginuser.ILoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginUserService implements ILoginUserService{
    @Autowired
    private ILoginUserRepository loginUserRepository;

    @Override
    public List<LoginUser> findALl() {
        return (List<LoginUser>) loginUserRepository.findAll();
    }

    @Override
    public Page<LoginUser> findALl(Pageable pageable) {
        return loginUserRepository.findAll(pageable);
    }

    @Override
    public LoginUser findById(Long id) throws NotFoundException {
        return loginUserRepository.findById(id).get();
    }

    @Override
    public LoginUser save(LoginUser loginUser) {
        return loginUserRepository.save(loginUser);
    }

    @Override
    public void deleteById(Long id) {
        loginUserRepository.deleteById(id);
    }
}
