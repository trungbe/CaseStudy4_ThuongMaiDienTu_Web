package com.module4.casestudy.repository;

import com.module4.casestudy.model.LoginUser;
import com.module4.casestudy.model.Product;
import com.module4.casestudy.model.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<UserComment,Long> {
    List<UserComment> findUserCommentByProduct(Product product);
    List<UserComment> findUserCommentByLoginUser(LoginUser loginUser);
}
