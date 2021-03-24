package com.module4.casestudy.service.Bill;



import com.module4.casestudy.model.Bill;
import com.module4.casestudy.service.IService;

import java.util.List;

public interface IBillService extends IService<Bill> {

    List<Bill> findBillNotPayByUserId(Long userId);
}
