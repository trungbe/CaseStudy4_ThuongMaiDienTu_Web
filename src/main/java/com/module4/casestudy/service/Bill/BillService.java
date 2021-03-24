package com.module4.casestudy.service.Bill;


import com.module4.casestudy.model.Bill;
import com.module4.casestudy.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {

    @Autowired
    private BillRepository billRepository;


    @Override
    public List<Bill> findALl() {
        return billRepository.findAll();
    }

    @Override
    public Page<Bill> findALl(Pageable pageable) {
        return  billRepository.findAll(pageable);

    }

    @Override
    public Bill findById(Long id) {
        return (Bill) billRepository.findById(id).get();
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void deleteById(Long id) {

        billRepository.deleteById(id);
    }
    @Override
    public List<Bill> findBillNotPayByUserId(Long userId){
        return billRepository.findBillNotPayByUserId(userId);
    }



}
