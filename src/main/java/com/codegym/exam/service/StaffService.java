package com.codegym.exam.service;

import com.codegym.exam.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    Page<Staff> findAll(Pageable pageable);

    Staff findById(Long id);

    void save(Staff staff);

    void remove(Long id);

    Page<Staff> findAllByName(String search, Pageable pageable);
}
