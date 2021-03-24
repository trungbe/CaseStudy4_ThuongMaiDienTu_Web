package com.module4.casestudy.service.appuser;

import com.module4.casestudy.model.LoginUser;

public interface IAppUserService {
    LoginUser getUserByName(String name);
    LoginUser getCurrentUser();
}
