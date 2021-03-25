package com.module4.casestudy.service.shop;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.Shop;
import com.module4.casestudy.service.IService;

public interface IShopService extends IService {
    Shop findAllByLoginUser(LoginUser loginUser);
}
