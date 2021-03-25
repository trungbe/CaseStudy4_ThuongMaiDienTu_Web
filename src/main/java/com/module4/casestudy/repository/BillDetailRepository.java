package com.module4.casestudy.repository;


import com.module4.casestudy.model.Bill;
import com.module4.casestudy.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Long> {

        List<BillDetail> findAllByBill(Bill bill);

        @Query( value = "select sum(p.price*bill_detail.number) from bill_detail join product p on p.id = bill_detail.product_id where bill_detail.bill_id = ?;", nativeQuery = true)
        Double calculateMoneyByBillId(Long billId);

}
