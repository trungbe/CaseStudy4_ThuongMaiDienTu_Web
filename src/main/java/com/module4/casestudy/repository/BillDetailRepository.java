package com.module4.casestudy.repository;


import com.module4.casestudy.model.Bill;
import com.module4.casestudy.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Long> {

        List<BillDetail> findAllByBill(Bill bill);

//        @Override
//        @Query(value = "select * from bill_detail where id = ?", nativeQuery = true)
//        Optional<BillDetail> findById(Long id);

}
