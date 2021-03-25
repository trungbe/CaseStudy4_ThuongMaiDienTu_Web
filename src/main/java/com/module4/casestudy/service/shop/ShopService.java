package com.module4.casestudy.service.shop;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.Shop;
import com.module4.casestudy.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopService implements IShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List findALl() {
        return null;
    }

    @Override
    public Page findALl(Pageable pageable) {
        return null;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Shop findAllByLoginUser(LoginUser loginUser) {
        return shopRepository.findAllByLoginUser(loginUser);
    }
}
