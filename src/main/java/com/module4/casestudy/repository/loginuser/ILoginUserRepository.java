package com.module4.casestudy.repository.loginuser;

import com.module4.casestudy.model.LoginUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginUserRepository extends PagingAndSortingRepository<LoginUser, Long> {

}
