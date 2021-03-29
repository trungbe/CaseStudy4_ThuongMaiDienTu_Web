package com.module4.casestudy.service.statistical;

import com.module4.casestudy.repository.StatisticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticalService implements IStatisticalService {
    @Autowired
    private StatisticalRepository statisticalRepository;
    @Override
    public Long getDataByMonth(Integer month, Long shopID) {
        return statisticalRepository.getTotal(month, shopID);
    }
}
