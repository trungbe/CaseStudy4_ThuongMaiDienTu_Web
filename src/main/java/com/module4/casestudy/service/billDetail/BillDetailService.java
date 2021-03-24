package com.module4.casestudy.service.billDetail;


import com.module4.casestudy.model.Bill;
import com.module4.casestudy.model.BillDetail;
import com.module4.casestudy.repository.BillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BillDetailService implements IBillDetailService {

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public List<BillDetail> findALl() {
        return billDetailRepository.findAll();
    }

    @Override
    public Page<BillDetail> findALl(Pageable pageable) {
        return billDetailRepository.findAll(pageable);
    }

    @Override
    public BillDetail findById(Long id) {
        return billDetailRepository.findById(id).get();
    }

    @Override
    public BillDetail save(BillDetail billDetail) {
        return billDetailRepository.save(billDetail);
    }

    @Override
    public void deleteById(Long id) {

        billDetailRepository.deleteById(id);
    }

    @Override
    public List<BillDetail> findALlByBill(Bill bill) {
        return billDetailRepository.findAllByBill(bill);
    }
}
