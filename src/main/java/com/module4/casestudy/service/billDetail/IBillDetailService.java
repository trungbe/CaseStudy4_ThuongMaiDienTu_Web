package com.module4.casestudy.service.billDetail;



import com.module4.casestudy.model.Bill;
import com.module4.casestudy.model.BillDetail;
import com.module4.casestudy.service.IService;

import java.util.List;

public interface IBillDetailService extends IService<BillDetail> {


    List<BillDetail> findALlByBill(Bill bill);
    Double calculateMoneyByBillId(Long BillId);
}
