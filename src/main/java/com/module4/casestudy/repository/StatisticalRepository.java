package com.module4.casestudy.repository;

import com.module4.casestudy.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticalRepository extends JpaRepository<Bill, Long> {
    @Query(value = "SELECT SUM(total_money) as 'total' FROM bill WHERE MONTH(date) = :month AND shop_id = :shopId ", nativeQuery = true)
    Long getTotal(@Param("month") Integer month, @Param("shopId") Long shopId);
}
