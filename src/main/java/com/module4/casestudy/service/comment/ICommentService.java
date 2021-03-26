package com.module4.casestudy.service.comment;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.Product;
import com.module4.casestudy.model.UserComment;
import com.module4.casestudy.service.IService;

import java.util.List;

public interface ICommentService extends IService<UserComment> {

    List<UserComment> findUserCommentByProduct(Product product);
    List<UserComment> findUserCommentByLoginUser(LoginUser loginUser);
}
