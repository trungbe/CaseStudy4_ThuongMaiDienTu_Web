package com.module4.casestudy.repository;

import com.module4.casestudy.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
    @Query(value = "select * from bill where login_user_id = ? and status = false;", nativeQuery = true)
    public List<Bill> findBillNotPayByUserId(Long userId);

}
