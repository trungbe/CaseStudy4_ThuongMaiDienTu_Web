package com.module4.casestudy.service;

import com.module4.casestudy.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T>{

    List<T> findALl();

    Page<T> findALl(Pageable pageable);

    T findById(Long id) throws NotFoundException;

    T save(T t);

    void deleteById(Long id);

}
